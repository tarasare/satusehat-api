package id.co.klikdata.satusehat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import id.co.klikdata.satusehat.dto.PatientResponse;
import id.co.klikdata.satusehat.dto.PractitionerResponse;
import id.co.klikdata.satusehat.dto.TokenResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SatuSehatServiceImpl implements SatuSehatService {
    private final RestTemplate restTemplate;

    private final static String URL_AUTH = "https://api-satusehat-dev.dto.kemkes.go.id/oauth2/v1/accesstoken?grant_type=client_credentials";
    private final static String URL_PASIEN = "https://api-satusehat-dev.dto.kemkes.go.id/fhir-r4/v1/Patient";
    private final static String URL_PRACTITIONER = "https://api-satusehat-dev.dto.kemkes.go.id/fhir-r4/v1/Practitioner";

    @Value("${satusehat.clientId}")
    private String clientId;

    @Value("${satusehat.clientSecret}")
    private String clientSecret;

    @Override
    public PractitionerResponse getDokterByNik(String nik) {
        try {
            String token = getAccessToken().getAccessToken();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
            ResponseEntity<PractitionerResponse> response = restTemplate.exchange(
                    URL_PRACTITIONER + "?identifier=https://fhir.kemkes.go.id/id/nik|"
                            + nik,
                    HttpMethod.GET, request,
                    PractitionerResponse.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // PASIEN SERVICE
    @Override
    public PatientResponse getPasientByNik(String nik) {
        try {
            String token = getAccessToken().getAccessToken();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
            ResponseEntity<PatientResponse> response = restTemplate.exchange(
                    URL_PASIEN + "?identifier=https://fhir.kemkes.go.id/id/nik|"
                            + nik,
                    HttpMethod.GET, request,
                    PatientResponse.class);

            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TokenResponse getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(URL_AUTH, request, TokenResponse.class);
        return response.getBody();
    }

}
