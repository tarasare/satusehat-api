package id.co.klikdata.satusehat.dto.Organization.response;

import java.util.List;

import lombok.Data;

@Data
public class Address {
    private String country;
    private List<Extension> extension;
    private String city;
    private List<String> line;
    private String use;
    private Integer postalCode;
    private String type;
}
