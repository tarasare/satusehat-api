package id.co.klikdata.satusehat.dto.Location.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String use;
    private List<String> line;
    private String city;
    private String postalCode;
    private String country;
    private List<AddressExtension> extension;
}
