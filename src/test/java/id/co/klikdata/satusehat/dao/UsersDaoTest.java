package id.co.klikdata.satusehat.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import id.co.klikdata.satusehat.entity.Users;

@SpringBootTest
public class UsersDaoTest {
    @Autowired
    private UsersDao usersDao;

    @Test
    public void getPasienTest() {
        Users users = usersDao.findByNoIdentitasAndGrupUser("5271002009700008", 1);
        System.out.println(users);
    }
}
