package id.co.klikdata.satusehat.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_medrec")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_register")
    private BigInteger noRegister;

    @Column(name = "tgl_masuk")
    private Date tglMasuk;

    @Column(name = "sts_pencatatan")
    private Integer stsPencatatan;

    @Column(name = "id_pasien")
    private Long idPasien;

    @Column(name = "umur_thn")
    private Integer umurThn;

    @Column(name = "umur_bln")
    private Integer umurBln;

    @Column(name = "umur_hri")
    private Integer umurHri;

    @Column(name = "sts_kunjungan_pasien")
    private Integer stsKunjunganPasien;

    @Column(name = "id_jenis_rawatan")
    private Integer idJenisRawatan;

    @Column(name = "is_ugd")
    private Integer isUgd;

    @Column(name = "lakalantas")
    private Integer lakalantas;

    @Column(name = "id_grup_dokter")
    private Integer idGrupDokter;

    @Column(name = "id_caradaftar")
    private Integer idCaradaftar;

    @Column(name = "id_sumber_pasien")
    private Integer idSumberPasien;

    @Column(name = "rujukan_no")
    private String rujukanNo;

    @Column(name = "sep_number")
    private String sepNumber;

    @Column(name = "sep_tanggal")
    private Date sepTanggal;

    @Column(name = "id_asuransi_dipakai")
    private Integer idAsuransiDipakai;

    @Column(name = "id_kelas_rawatan_diambil")
    private Integer idKelasRawatanDiambil;

    @Column(name = "id_ruangan")
    private Integer idRuangan;

    @Column(name = "id_dokter")
    private Long idDokter;

    @Column(name = "id_kesadaran")
    private Integer idKesadaran;

    @Column(name = "darah_sistol")
    private Double darahSistol;

    @Column(name = "darah_diastol")
    private Double darahDiastol;

    @Column(name = "denyut_nadi")
    private Double denyutNadi;

    @Column(name = "pernafasan")
    private Double pernafasan;

    @Column(name = "badan_suhu")
    private Double badan;

}