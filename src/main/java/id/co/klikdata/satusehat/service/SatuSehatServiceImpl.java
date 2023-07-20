package id.co.klikdata.satusehat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import id.co.klikdata.satusehat.dao.SettingsDao;
import id.co.klikdata.satusehat.dto.TokenResponse;
import id.co.klikdata.satusehat.entity.Settings;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SatuSehatServiceImpl implements SatuSehatService {
    private final RestTemplate restTemplate;
    private final SettingsDao settingsDao;

    @Value("${satusehat.clientId}")
    private String clientId;

    @Value("${satusehat.clientSecret}")
    private String clientSecret;

    @Override

    public TokenResponse getAccessToken() {
        Settings settings = settingsDao.findAll().get(0);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", settings.getClientKey());
        map.add("client_secret", settings.getSecretKey());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(SatuSehat.URL_AUTH, request,
                TokenResponse.class);

        return response.getBody();
    }

}
