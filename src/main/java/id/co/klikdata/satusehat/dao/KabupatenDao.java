package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.Kabupaten;

public interface KabupatenDao extends JpaRepository<Kabupaten, Integer> {

    Kabupaten findByIdProv(Integer idProv);

}
