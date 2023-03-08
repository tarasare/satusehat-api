package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_ruangan_grup")
public class GrupRuangan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grup_ruangan")
    private Long id;

    @Column(name = "nama_grup_ruangan")
    private String namaGrupRuangan;

    @Column(name = "id_jenis_ruangan")
    private Integer idJenisRuangan;

    private String idIhs;
}
