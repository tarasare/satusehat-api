package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.Pasien;

public interface PasienDao extends JpaRepository<Pasien, Long> {

    Pasien findByNoIdentitas(String nik);

    Pasien findByNoIdentitasAndGrupUser(String nik, int i);

}
