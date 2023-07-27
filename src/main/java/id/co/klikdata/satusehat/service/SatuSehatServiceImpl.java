package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.SatuSehatConfigDao;
import id.co.klikdata.satusehat.dto.TokenResponse;
import id.co.klikdata.satusehat.entity.SatuSehatConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class SatuSehatServiceImpl implements SatuSehatService {
    private final RestTemplate restTemplate;
    private final SatuSehatConfigDao satuSehatConfigDao;

    @Override
    public TokenResponse getAccessToken() {
        SatuSehatConfig settings = satuSehatConfigDao.findByIsActive(true);
        long selisihMenit = ChronoUnit.MINUTES.between(settings.getUpdatedAt(), LocalDateTime.now());
        if(selisihMenit > 40) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("client_id", settings.getClientId());
            map.add("client_secret", settings.getSecretId());
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            ResponseEntity<TokenResponse> response = restTemplate.postForEntity(settings.getBaseUrl() + "/oauth2/v1/accesstoken?grant_type=client_credentials", request,
                    TokenResponse.class);
            settings.setAccessToken(response.getBody().getAccessToken());
            settings.setUpdatedAt(LocalDateTime.now());
            satuSehatConfigDao.save(settings);
            return response.getBody();
        }


        TokenResponse token = new TokenResponse();
        token.setAccessToken(settings.getAccessToken());
        return token;
    }

    @Override
    public String getBaseUrl() {
        SatuSehatConfig settings = satuSehatConfigDao.findByIsActive(true);
        return settings.getBaseUrl();
    }



}
