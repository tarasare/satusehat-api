package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.Users;

public interface UsersDao extends JpaRepository<Users, Long> {

    Users findByNoIdentitas(String nik);

    Users findByNoIdentitasAndGrupUser(String nik, int i);

}
