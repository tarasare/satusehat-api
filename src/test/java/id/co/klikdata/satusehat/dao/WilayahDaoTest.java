package id.co.klikdata.satusehat.dao;

import java.util.List;

import id.co.klikdata.satusehat.dto.Wilayah.DataResponse;
import id.co.klikdata.satusehat.dto.Wilayah.KecamatanDto;
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
    public void getKabupatenTest() {
        kabupatenDao.findAll().forEach(item -> {
            System.out.println(item.getNamaKabkota());
        });
    }

    @Test
    public void updateDataWilayahTest() {
        provinsiDao.findAll().forEach(prov -> {

            getKabupaten(prov.getIdKemendagri().toString()).forEach(item -> {
                String id = item.getKodeDagri().replace(".", "");
                Kabupaten kab = kabupatenDao.findByNamaKabkota(prov.getIdProv(),item.getNamaDagri().replace("KAB. ", ""));
                if(kab != null) {
                    kab.setIdKemendagri(id);
                    kab.setNamaKemendagri(item.getNamaDagri());
                    kabupatenDao.save(kab);
                }
            });
        });
    }

    @Test
    public void DataKecamatanTest() {
        kabupatenDao.findAll().forEach(kab -> {
            if(kab.getIdKemendagri() != null) {
                getKecamatan(kab.getIdKemendagri()).getData().forEach(item -> {
                    System.out.println(item.getKode() + " - " + item.getNama());
                });
            }
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


    private DataResponse<List<KecamatanDto>> getKecamatan(String kode) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
//        String url = "https://sig.bps.go.id/rest-bridging/getwilayah?level=kecamatan&parent=" + kode;
        String url = "http://localhost:3000/api/v1/wilayah/kecamatan";
        ResponseEntity<DataResponse<List<KecamatanDto>>> response = restTemplate.exchange(url, HttpMethod.GET, request,
                new ParameterizedTypeReference<DataResponse<List<KecamatanDto>>>() {
                });
        return response.getBody();
    }
}
