package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.PendaftaranDao;
import id.co.klikdata.satusehat.dao.SettingsDao;
import id.co.klikdata.satusehat.dto.Condition.request.ConditionRequest;
import id.co.klikdata.satusehat.dto.Condition.response.ConditionResponse;
import id.co.klikdata.satusehat.dto.Encounter.response.EncounterResponse;
import id.co.klikdata.satusehat.entity.Pendaftaran;
import id.co.klikdata.satusehat.entity.Settings;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {
    private final PendaftaranDao pendaftaranDao;
    private final SettingsDao settingsDao;
    private final SatuSehatService satuSehatService;
    private final RestTemplate restTemplate;


    @Override
    public ConditionResponse create(String nomor) {
        Settings settings = settingsDao.findAll().get(0);
        Pendaftaran pendaftaran = pendaftaranDao.findById(new BigInteger(nomor)).get();


        ConditionRequest req = new ConditionRequest();

        req.setResourceType("Condition");

        List<ConditionRequest.Coding> codings = new ArrayList<>();
        codings.add(new ConditionRequest.Coding("http://terminology.hl7.org/CodeSystem/condition-clinical", "active", "Active"));
        req.setClinicalStatus(new ConditionRequest.ClinicalStatus(codings));

        List<ConditionRequest.CategoryWrapper> categoryWrappers = new ArrayList<>();
        List<ConditionRequest.Coding> codings1 = new ArrayList<>();
        codings1.add(new ConditionRequest.Coding("http://terminology.hl7.org/CodeSystem/condition-category", "encounter-diagnosis", "Encounter Diagnosis"));
        categoryWrappers.add(new ConditionRequest.CategoryWrapper(codings1));
        req.setCategory(categoryWrappers);

        List<ConditionRequest.Coding> codings2 = new ArrayList<>();
        codings2.add(new ConditionRequest.Coding("http://hl7.org/fhir/sid/icd-10", "", ""));
        req.setCode(new ConditionRequest.CodeWrapper(codings2));

        req.setSubject(new ConditionRequest.Subject("Patient/" + pendaftaran.getPasien().getIdPasienIhs(), pendaftaran.getPasien().getNamaUser()));
        req.setEncounter(new ConditionRequest.EncounterWrapper("Encounter/" + pendaftaran.getIdIhs(), ""));

        String token = satuSehatService.getAccessToken().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<ConditionRequest> request = new HttpEntity<>(req, headers);
        ResponseEntity<ConditionResponse> response = restTemplate.exchange(
                SatuSehat.URL_ENCOUNTER,
                HttpMethod.POST, request,
                ConditionResponse.class);


        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
//            pendaftaran.setIdIhs(String.valueOf(response.getBody().getId()));
//            pendaftaranDao.save(pendaftaran);
        }


        return response.getBody();
    }
}
