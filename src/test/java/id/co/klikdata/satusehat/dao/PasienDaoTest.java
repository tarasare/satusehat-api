package id.co.klikdata.satusehat.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.co.klikdata.satusehat.entity.Pasien;

@SpringBootTest
public class PasienDaoTest {
    @Autowired
    private PasienDao pasienDao;

    @Test
    public void getPasienTest() {
        Pasien pasien = pasienDao.findByNoIdentitasAndGrupUser("5271002009700008", 1);
        System.out.println(pasien);
    }
}
