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

    @ManyToOne() 
    @JoinColumn(name = "id_prov" )
    private Provinsi provinsi;

    @ManyToOne()
    @JoinColumn(name = "id_kabkota")
    private Kabupaten kabupaten;


   @ManyToOne()
   @JoinColumn(name = "id_kec")
    private Kecamatan kecamatan;

    @ManyToOne()
    @JoinColumn(name = "id_kel")
    private Kelurahan kelurahan;

        @Column(name = "rs_kabkota")
    @JsonProperty("rs_kabkota")
    private String namaKabKota;

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
