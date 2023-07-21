package id.co.klikdata.satusehat.dao;

import id.co.klikdata.satusehat.entity.Diagnosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface DiagnosaDao extends JpaRepository<Diagnosa, Long> {

    @Query(value = "SELECT * FROM tbl_medrec_dx WHERE no_register=:nomor AND sts_primer=1", nativeQuery = true)
    Diagnosa findByNoRegister(@Param("nomor") BigInteger nomor);
}
