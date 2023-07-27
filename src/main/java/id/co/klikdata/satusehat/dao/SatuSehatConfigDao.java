package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.SatuSehatConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatuSehatConfigDao extends JpaRepository<SatuSehatConfig, Integer> {
    SatuSehatConfig findByIsActive(boolean b);
}
