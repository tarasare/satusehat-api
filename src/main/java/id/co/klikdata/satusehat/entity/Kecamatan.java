package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_kec")
public class Kecamatan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKec;

    private String namaKecamatan;
    private Integer idKabkota;
    private String isactive;
    private String idKemendagri;
}