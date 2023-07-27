package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.Ruangan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuanganDao extends JpaRepository<Ruangan, Long> {
    List<Ruangan> findByIsactiveAndIdIhs(int i, Object o);
}
