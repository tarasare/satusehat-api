package id.co.klikdata.satusehat.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbl_pendaftaran")
public class Pendaftaran {

    @Id
    @Column(name = "no_register")
    private BigInteger noRegister;

    @Column(name = "tgl_daftar")
    private LocalDateTime tglDaftar;

    private LocalDateTime tglBerobat;


//    @Column(name = "id_ruangan")
//    private Integer idRuangan;

    @ManyToOne
    @JoinColumn(name = "id_ruangan")
    private Ruangan ruangan;

    @ManyToOne
    @JoinColumn(name = "id_dokter")
    private Users dokter;

    @Column(name = "id_faskes")
    private Integer idFaskes;

    @Column(name = "id_loket")
    private Integer idLoket;

    @Column(name = "no_tiket")
    private String noTiket;

    @Column(name = "no_urut")
    private String noUrut;

    @ManyToOne
    @JoinColumn(name = "id_pasien")
    private Users pasien;

    @Column(name = "umur_thn")
    private Integer umurThn;

    @Column(name = "umur_bln")
    private Integer umurBln;

    @Column(name = "umur_hri")
    private Integer umurHri;

    @Column(name = "id_jenis_rawatan")
    private Integer idJenisRawatan;

    @Column(name = "is_ugd")
    private Integer isUgd;

    @Column(name = "jenis_pelayanan_ugd")
    private Integer jenisPelayananUgd;


    @Column(name = "lakalantas")
    private Integer lakalantas;


    @Column(name = "id_kec_lakalantas")
    private String idKecLakalantas;

    @Column(name = "tgl_lakalantas")
    private LocalDate tglLakalantas;

    @Column(name = "no_lp")
    private String noLp;

    @Column(name = "ket_lakalantas")
    private String ketLakalantas;


    @Column(name = "id_caradaftar")
    private Integer idCaradaftar;

    @Column(name = "id_sumber_pasien")
    private Integer idSumberPasien;

    private String idIhs;

}

