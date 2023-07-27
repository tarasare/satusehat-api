package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.SatuSehatConfigDao;
import id.co.klikdata.satusehat.entity.SatuSehatConfig;
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
    private final SatuSehatConfigDao satuSehatConfigDao;

    @Value("${satusehat.clientId}")
    private String clientId;

    @Value("${satusehat.clientSecret}")
    private String clientSecret;

    @Override
    public TokenResponse getAccessToken() {
        SatuSehatConfig settings = satuSehatConfigDao.findByIsActive(true);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", settings.getClientId());
        map.add("client_secret", settings.getSecretId());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<TokenResponse> response = restTemplate.postForEntity(settings.getBackendUrl() + "/oauth2/v1/accesstoken?grant_type=client_credentials", request,
                TokenResponse.class);

        return response.getBody();
    }

    @Override
    public String getBaseUrl() {
        SatuSehatConfig settings = satuSehatConfigDao.findByIsActive(true);
        return settings.getBaseUrl();
    }

}
