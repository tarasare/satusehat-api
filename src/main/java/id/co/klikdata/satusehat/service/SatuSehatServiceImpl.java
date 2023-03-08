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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.co.klikdata.satusehat.dto.PatientResponse;
import id.co.klikdata.satusehat.dto.PractitionerResponse;
import id.co.klikdata.satusehat.dto.TokenResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SatuSehatServiceImpl implements SatuSehatService {
    private final RestTemplate restTemplate;

    @Value("${satusehat.clientId}")
    private String clientId;

    @Value("${satusehat.clientSecret}")
    private String clientSecret;

    @Value("${satusehat.uriAuth}")
    private String uriAuth;

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
                    "https://api-satusehat-dev.dto.kemkes.go.id/fhir-r4/v1/Practitioner?identifier=https://fhir.kemkes.go.id/id/nik|"
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
                    "https://api-satusehat-dev.dto.kemkes.go.id/fhir-r4/v1/Patient?identifier=https://fhir.kemkes.go.id/id/nik|"
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
    public ResponseEntity<JsonNode> getPasienByNameGenderAndBirthdate(String name, String gender, String birthdate)
            throws JsonMappingException, JsonProcessingException {
        try {
            String token = getAccessToken().getAccessToken();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(token);
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("name", name);
            params.add("birthdate", birthdate);
            params.add("gender", gender);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
            ResponseEntity<String> response = restTemplate.exchange(
                    "https://api-satusehat-dev.dto.kemkes.go.id/fhir-r4/v1/Patient",
                    HttpMethod.GET, request,
                    String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            return ResponseEntity.ok(jsonNode);
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(e.getMessage());
            return ResponseEntity.ok(jsonNode);
        }
    }

    private TokenResponse getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(uriAuth, request, TokenResponse.class);
        return response.getBody();
    }

}
