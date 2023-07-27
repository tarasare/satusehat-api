package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.DiagnosaDao;
import id.co.klikdata.satusehat.dao.KodeIhsDao;
import id.co.klikdata.satusehat.dao.PendaftaranDao;
import id.co.klikdata.satusehat.dao.SettingsDao;
import id.co.klikdata.satusehat.dto.Condition.request.ConditionRequest;
import id.co.klikdata.satusehat.dto.Condition.response.ConditionResponse;
import id.co.klikdata.satusehat.entity.Diagnosa;
import id.co.klikdata.satusehat.entity.KodeIhs;
import id.co.klikdata.satusehat.entity.Pendaftaran;
import id.co.klikdata.satusehat.entity.Settings;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ConditionServiceImpl implements ConditionService {
    private final PendaftaranDao pendaftaranDao;
    private final SettingsDao settingsDao;
    private final SatuSehatService satuSehatService;
    private final RestTemplate restTemplate;
    private final DiagnosaDao diagnosaDao;
    private final KodeIhsDao kodeIhsDao;

    @Override
    public ConditionResponse create(String nomor) {
        Pendaftaran pendaftaran = pendaftaranDao.findById(new BigInteger(nomor)).get();
        Diagnosa diagnosa = diagnosaDao.findByNoRegister(pendaftaran.getNoRegister());
        KodeIhs kode = kodeIhsDao.findById(pendaftaran.getNoRegister()).get();
//
//        ConditionRequest req = new ConditionRequest();
//
//        req.setResourceType("Condition");
//
//        List<ConditionRequest.Coding> codings = new ArrayList<>();
//        codings.add(new ConditionRequest.Coding("http://terminology.hl7.org/CodeSystem/condition-clinical", "active", "Active"));
//        req.setClinicalStatus(new ConditionRequest.ClinicalStatus(codings));
//
//        List<ConditionRequest.CategoryWrapper> categoryWrappers = new ArrayList<>();
//        List<ConditionRequest.Coding> codings1 = new ArrayList<>();
//        codings1.add(new ConditionRequest.Coding("http://terminology.hl7.org/CodeSystem/condition-category", "encounter-diagnosis", "Encounter Diagnosis"));
//        categoryWrappers.add(new ConditionRequest.CategoryWrapper(codings1));
//        req.setCategory(categoryWrappers);
//
//        List<ConditionRequest.Coding> codings2 = new ArrayList<>();
//        codings2.add(new ConditionRequest.Coding("http://hl7.org/fhir/sid/icd-10", diagnosa.getDiagnosaDokter().getIdCode(), diagnosa.getDiagnosaDokter().getKetEnglish()));
//        req.setCode(new ConditionRequest.CodeWrapper(codings2));
//
//        String hari = pendaftaran.getTglBerobat().getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("id", "ID"));
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("id", "ID"));
//
//        req.setSubject(new ConditionRequest.Subject("Patient/" + pendaftaran.getPasien().getIdPasienIhs(), pendaftaran.getPasien().getNamaUser()));
//        req.setEncounter(new ConditionRequest.EncounterWrapper("Encounter/" + pendaftaran.getIdIhs(), "Kunjungan " + pendaftaran.getPasien().getNamaUser() + " di hari " + hari +", " + pendaftaran.getTglBerobat().format(formatter)));
//
//        String token = satuSehatService.getAccessToken().getAccessToken();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(token);
//        HttpEntity<ConditionRequest> request = new HttpEntity<>(req, headers);
//        ResponseEntity<ConditionResponse> response = restTemplate.exchange(
//                satuSehatService.getBaseUrl() + "/fhir-r4/v1/Condition",
//                HttpMethod.POST, request,
//                ConditionResponse.class);
//
//
//        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
//            kode.setIhsCondition(Objects.requireNonNull(response.getBody()).getId());
//            kodeIhsDao.save(kode);
//        }


        return null;
    }
}
