package id.co.klikdata.satusehat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenResponse {
    @JsonProperty("refresh_token_expires_in")
    private String refreshTokenExpiresIn;

    @JsonProperty("api_product_list")
    private String apiProductList;

    @JsonProperty("api_product_list_json")
    private String[] apiProductListJson;

    @JsonProperty("organization_name")
    private String organizationName;

    @JsonProperty("developer.email")
    private String developerEmail;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("issued_at")
    private String issuedAt;

    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("application_name")
    private String applicationName;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("expires_in")
    private String expiresIn;

    @JsonProperty("refresh_count")
    private String refreshCount;

    @JsonProperty("status")
    private String status;
}
