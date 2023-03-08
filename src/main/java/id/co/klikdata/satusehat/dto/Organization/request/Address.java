package id.co.klikdata.satusehat.dto.Organization.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String use;
    private String type;
    private String[] line;
    private String city;
    private String postalCode;
    private String country;
    private List<Extension> extension;
}
