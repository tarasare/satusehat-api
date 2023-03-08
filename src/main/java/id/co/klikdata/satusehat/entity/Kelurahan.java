package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_desa")
public class Kelurahan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesa;

    private String namaDesa;
    private Integer idKec;
    private String isactive;
    private String idKemendagri;
}