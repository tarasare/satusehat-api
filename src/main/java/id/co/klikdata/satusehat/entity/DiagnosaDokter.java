package id.co.klikdata.satusehat.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "tbl_mst_icd10_local")
public class DiagnosaDokter {
    @Id
    @Column(name = "id_diagnosa")
    private BigInteger id;

    private String ketEnglish;
    private String idCode;
}
