package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.Ruangan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuanganDao extends JpaRepository<Ruangan, Long> {
}
