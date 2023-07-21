package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MedicalRecordDao extends JpaRepository<MedicalRecord, BigInteger> {
}
