package id.co.klikdata.satusehat.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_config_satusehat")
public class SatuSehatConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "auth_url")
    private String authUrl;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "backend_url")
    private String backendUrl;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "id_organization")
    private String idOrganization;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "secret_id")
    private String secretId;

    @Column(name = "isactive")
    private boolean isActive;

}

