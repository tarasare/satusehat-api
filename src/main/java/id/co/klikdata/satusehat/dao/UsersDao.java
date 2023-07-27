package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.Users;

import java.util.List;

public interface UsersDao extends JpaRepository<Users, Long> {

    Users findByNoIdentitas(String nik);

    Users findByNoIdentitasAndGrupUser(String nik, int i);

    List<Users> findByGrupUser(int i);

    List<Users> findByGrupUserAndIdPasienIhs(int i, Object o);

    List<Users> findByGrupUserAndIdPetugasIhs(int i, Object o);

    List<Users> findByGrupUserAndIsdefaultAndIdPetugasIhs(int i, int i1, Object o);
}
