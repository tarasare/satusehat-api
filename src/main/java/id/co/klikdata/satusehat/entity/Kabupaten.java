package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_kabkota")
public class Kabupaten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idKabkota;

    private String namaKabkota;
    private Integer idProv;
    private String isactive;
    private String idKemendagri;
    private String namaKemendagri;
}