package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.Pendaftaran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PendaftaranDao extends JpaRepository<Pendaftaran, BigInteger> {
}
