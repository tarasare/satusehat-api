package id.co.klikdata.satusehat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.klikdata.satusehat.entity.GrupRuangan;

import java.util.List;

public interface GrupRuanganDao extends JpaRepository<GrupRuangan, Integer> {

    List<GrupRuangan> findByIdIhs(Object o);
}
