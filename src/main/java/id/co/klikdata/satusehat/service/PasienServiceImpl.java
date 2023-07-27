package id.co.klikdata.satusehat.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import id.co.klikdata.satusehat.dao.UsersDao;
import id.co.klikdata.satusehat.dto.PatientResponse;
import id.co.klikdata.satusehat.entity.Users;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasienServiceImpl implements PasienService {
    private final RestTemplate restTemplate;
    private final SatuSehatService satuSehatService;
    private final UsersDao usersDao;

    @Override
    public PatientResponse getPasienByNik(String nik) {
        String token = satuSehatService.getAccessToken().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<PatientResponse> response = restTemplate.exchange(
                satuSehatService.getBaseUrl() + "/fhir-r4/v1/Patient?identifier=https://fhir.kemkes.go.id/id/nik|"
                        + nik,
                HttpMethod.GET, request,
                PatientResponse.class);
        if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody().getEntry() != null) {
            Users users = usersDao.findByNoIdentitas(nik);
            users.setIdPasienIhs(response.getBody().getEntry().get(0).getResource().getId());
            usersDao.save(users);
        }
        return response.getBody();
    }

    @Scheduled(fixedRate = 5000)
    public void scheduleFixedDelayTask() {
        System.out.println("RUN!");
        List<Users> data = usersDao.findByGrupUserAndIdPasienIhs(2, null);
        data.forEach(item -> {
            System.out.println(item.getNamaUser());
            getPasienByNik(item.getNoIdentitas());
        });
    }

}
