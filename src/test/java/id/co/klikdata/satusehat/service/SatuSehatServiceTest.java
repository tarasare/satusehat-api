package id.co.klikdata.satusehat.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.co.klikdata.satusehat.dto.PatientResponse;

@SpringBootTest
public class SatuSehatServiceTest {
    @Autowired
    private SatuSehatService satuSehatService;

    @Test
    public void getDataPasienTest() {
        PatientResponse data = satuSehatService.getPasientByNik("3171022809990001");
        System.out.println(data);
    }
}
