package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_ruangan")
public class Ruangan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ruangan")
    private Long id;

    @Column(name = "nama_ruangan")
    private String namaRuangan;

//    @Column(name = "id_grup_ruangan")
//    private String idGrupRuangan;

    @Column(name = "id_ihs")
    private String idIhs;

    @ManyToOne
    @JoinColumn(name = "id_grup_ruangan")
    private GrupRuangan grupRuangan;
}
