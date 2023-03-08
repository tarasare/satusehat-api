package id.co.klikdata.satusehat.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mst_user_system")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ub")
    @JsonProperty("id_ub")
    private Integer id;

    @Column(name = "rs_nama")
    @JsonProperty("rs_nama")
    private String nama;

    @Column(name = "rs_telp")
    @JsonProperty("rs_telp")
    private String telp;

    @Column(name = "rs_email")
    @JsonProperty("rs_email")
    private String email;

    @Column(name = "rs_website")
    @JsonProperty("rs_website")
    private String website;

    @Column(name = "rs_alamat")
    @JsonProperty("rs_alamat")
    private String alamat;

    @Column(name = "id_prov")
    @JsonProperty("id_prov")
    private String provinsi;

    @Column(name = "id_kabkota")
    @JsonProperty("id_kabkota")
    private String kabupaten;

    @Column(name = "rs_kabkota")
    @JsonProperty("rs_kabkota")
    private String namaKabKota;

    @Column(name = "id_kec")
    @JsonProperty("id_kec")
    private String kecamatan;

    @Column(name = "id_kel")
    @JsonProperty("id_kel")
    private String kelurahan;

    @Column(name = "rs_kode")
    @JsonProperty("rs_kode")
    private String kode;

    @Column(name = "client_key")
    @JsonProperty("client_key")
    private String clientKey;

    @Column(name = "secret_key")
    @JsonProperty("secret_key")
    private String secretKey;

    @Column(name = "organization_id")
    @JsonProperty("organization_id")
    private String organizationId;
}
