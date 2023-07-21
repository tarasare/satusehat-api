package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Data
@Entity
@Table(name = "tbl_medrec_dx")
public class Diagnosa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "no_register")
    private BigInteger noRegister;

//    @Column(name = "")
//    private Long idDiagnosa;

    @ManyToOne
    @JoinColumn(name = "id_diagnosa")
    private DiagnosaDokter diagnosaDokter;

    @Column(name = "ket_diagnosa")
    private String ketDiagnosa;

    @Column(name = "id_code")
    private String idCode;

    @Column(name = "sts_primer")
    private Integer stsPrimer;

    @Column(name = "sts_dx_claim")
    private Integer stsDxClaim;

    @Column(name = "status")
    private Integer status;
}
