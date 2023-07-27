package id.co.klikdata.satusehat.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import id.co.klikdata.satusehat.dao.UsersDao;
import id.co.klikdata.satusehat.dto.PractitionerResponse;
import id.co.klikdata.satusehat.entity.Users;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PractitionerServiceImpl implements PractitionerService {
    private final RestTemplate restTemplate;
    private final SatuSehatService satuSehatService;
    private final UsersDao usersDao;

    @Override
    public PractitionerResponse getDokterByNik(String nik) {
        String token = satuSehatService.getAccessToken().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        ResponseEntity<PractitionerResponse> response = restTemplate.exchange(
                satuSehatService.getBaseUrl() + "/fhir-r4/v1/Practitioner?identifier=https://fhir.kemkes.go.id/id/nik|"
                        + nik,
                HttpMethod.GET, request,
                PractitionerResponse.class);
        if (response.getStatusCode().equals(HttpStatus.OK) && response.getBody().getEntry() != null) {
            Users users = usersDao.findByNoIdentitasAndGrupUser(nik, 1);
            users.setIdPetugasIhs(response.getBody().getEntry().get(0).getResource().getId());
            usersDao.save(users);
        }
        return response.getBody();
    }

}
