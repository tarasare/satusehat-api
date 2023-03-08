package id.co.klikdata.satusehat.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import id.co.klikdata.satusehat.dto.Wilayah.KabupatenDto;
import id.co.klikdata.satusehat.entity.Kabupaten;

@SpringBootTest
public class WilayahDaoTest {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProvinsiDao provinsiDao;

    @Autowired
    private KabupatenDao kabupatenDao;

    @Autowired
    private KecamatanDao kecamatanDao;

    @Autowired
    private KelurahanDao kelurahanDao;

    @Test
    public void updateDataWilayahTest() {
        provinsiDao.findAll().forEach(prov -> {

            getKabupaten(prov.getIdKemendagri().toString()).forEach(item -> {
                // Kabupaten kabupaten = kabupatenDao.findByIdProv(prov.getIdProv());
                // kabupaten.setIdKemendagri(item.getKodeDagri().replace(".", ""));
                // Kabupaten save = kabupatenDao.save(kabupaten);
                System.out.println(item.getKodeDagri() + " - " + item.getNamaDagri());
            });
        });
    }

    private List<KabupatenDto> getKabupaten(String kode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
        String url = "https://sig.bps.go.id/rest-bridging/getwilayah?level=kabupaten&parent=" + kode;
        ResponseEntity<List<KabupatenDto>> response = restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<List<KabupatenDto>>() {
                });
        return response.getBody();
    }
}
