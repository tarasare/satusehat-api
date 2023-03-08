package id.co.klikdata.satusehat.dto.Organization.request;

import lombok.Data;

@Data
public class Address {
    private String use;
    private String type;
    private String[] line;
    private String city;
    private String postalCode;
    private String country;
    private Extension[] extension;
}
