package id.co.klikdata.satusehat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_user")
public class Pasien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    @JsonProperty("id_user")
    private Long id;

    @JsonProperty("nama_user")
    private String namaUser;

    @JsonProperty("gelar_blk")
    private String gelarBlk;

    @JsonProperty("foto")
    private String foto;

    @JsonProperty("tanda_tangan")
    private String tandaTangan;

    @JsonProperty("no_indentitas")
    private String noIdentitas;

    @JsonProperty("no_mr")
    private String noMr;

    @JsonProperty("no_mr_lama")
    private String noMrLama;

    @JsonProperty("kode_dpjp")
    private String kodeDpjp;

    @JsonProperty("gelar_dpn")
    private String gelarDpn;

    @JsonProperty("tmp_lhr")
    private String tmpLhr;

    @JsonProperty("tgl_lhr")
    private String tglLhr;

    @JsonProperty("id_jk")
    private Integer idJk;

    @JsonProperty("id_kawin")
    private Integer idKawin;

    @JsonProperty("id_agama")
    private Integer idAgama;

    @JsonProperty("gol_darah")
    private String golDarah;

    @JsonProperty("berat_lahir")
    private Integer beratLahir;

    @JsonProperty("id_jpdd")
    private Integer idJpdd;

    @JsonProperty("id_prodi")
    private Integer idProdi;

    @JsonProperty("id_pekerjaan")
    private Integer idPekerjaan;

    @JsonProperty("grup_user")
    private Integer grupUser;

    private String email;
    // private String alamat;

    @JsonProperty("id_pasien_ihs")
    private String idPasienIhs;

    @JsonProperty("id_petugas_ihs")
    private String idPetugasIhs;
}
