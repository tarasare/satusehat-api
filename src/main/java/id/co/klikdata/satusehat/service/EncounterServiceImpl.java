package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.PendaftaranDao;
import id.co.klikdata.satusehat.dao.KodeIhsDao;
import id.co.klikdata.satusehat.dao.SettingsDao;
import id.co.klikdata.satusehat.dto.Encounter.request.EncounterRequest;
import id.co.klikdata.satusehat.dto.Encounter.response.EncounterResponse;
import id.co.klikdata.satusehat.entity.KodeIhs;
import id.co.klikdata.satusehat.entity.Pendaftaran;
import id.co.klikdata.satusehat.entity.Settings;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EncounterServiceImpl implements EncounterService {
    private final PendaftaranDao pendaftaranDao;
    private final RestTemplate restTemplate;
    private final SatuSehatService satuSehatService;
    private final SettingsDao settingsDao;
    private final KodeIhsDao kodeIhsDao;

    @Override
    public EncounterResponse create(String nomor) {
        Settings settings = settingsDao.findAll().get(0);
        Pendaftaran pendaftaran = pendaftaranDao.findById(new BigInteger(nomor)).get();

        EncounterRequest req = new EncounterRequest();

        req.setResourceType("Encounter");
        req.setStatus("arrived");
        req.setEncounterClass(new EncounterRequest.ClassDetails("http://terminology.hl7.org/CodeSystem/v3-ActCode", "AMB", "ambulatory"));
        req.setSubject(new EncounterRequest.Subject("Patient/" + pendaftaran.getPasien().getIdPasienIhs(), pendaftaran.getPasien().getNamaUser()));

        List<EncounterRequest.Type> types = new ArrayList<>();
        List<EncounterRequest.Coding> codings = new ArrayList<>();
        codings.add(new EncounterRequest.Coding("http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "ATND", "attender"));
        types.add(new EncounterRequest.Type(codings));

        String namaDokter = pendaftaran.getDokter().getGelarDpn() + " " + pendaftaran.getDokter().getNamaUser() + ", " + pendaftaran.getDokter().getGelarBlk();
         EncounterRequest.Individual individual = new EncounterRequest.Individual("Practitioner/" + pendaftaran.getDokter().getIdPetugasIhs() , namaDokter);

        List<EncounterRequest.Participant> participants = new ArrayList<>();
        participants.add(new EncounterRequest.Participant(types, individual));
        req.setParticipant(participants);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        OffsetDateTime offsetDateTime = pendaftaran.getTglBerobat().atOffset(ZoneOffset.ofHours(7));
        String tanggalBerobat = offsetDateTime.format(outputFormatter);


        req.setPeriod(new EncounterRequest.Period(tanggalBerobat));


        System.out.println("Location/" + pendaftaran.getRuangan().getIdIhs());
        List<EncounterRequest.LocationWrapper> locations = new ArrayList<>();
        locations.add(new EncounterRequest.LocationWrapper(new EncounterRequest.Location("Location/" + pendaftaran.getRuangan().getIdIhs(), pendaftaran.getRuangan().getNamaRuangan())));
        req.setLocation(locations);

        List<EncounterRequest.StatusHistory> statusHistories = new ArrayList<>();
        statusHistories.add(new EncounterRequest.StatusHistory("arrived", new EncounterRequest.Period(tanggalBerobat)));
        req.setStatusHistory(statusHistories);

        req.setServiceProvider(new EncounterRequest.ServiceProvider("Organization/" + settings.getOrganizationId()));

        List<EncounterRequest.Identifier> identifiers = new ArrayList<>();
        identifiers.add(new EncounterRequest.Identifier("http://sys-ids.kemkes.go.id/encounter/" + settings.getOrganizationId(), pendaftaran.getNoTiket()));
        req.setIdentifier(identifiers);

        String token = satuSehatService.getAccessToken().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<EncounterRequest> request = new HttpEntity<>(req, headers);
        ResponseEntity<EncounterResponse> response = restTemplate.exchange(
                satuSehatService.getBaseUrl() + "/fhir-r4/v1/Encounter",
                HttpMethod.POST, request,
                EncounterResponse.class);

        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            KodeIhs ihs = new KodeIhs();
            ihs.setNoRegister(pendaftaran.getNoRegister());
            ihs.setIhsEncounter(String.valueOf(response.getBody().getId()));
            kodeIhsDao.save(ihs);
        }

        return response.getBody();
    }
}
