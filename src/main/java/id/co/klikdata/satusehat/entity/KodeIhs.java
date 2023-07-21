package id.co.klikdata.satusehat.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "tbl_satusehat_ihs_pendaftaran")
public class KodeIhs {
    @Id
    private BigInteger noRegister;
    private String ihsEncounter;
    private String ihsCondition;
    private String ihsConditionSelesai;
    private String ihsObservationTtv;
}
