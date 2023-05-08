package id.co.klikdata.satusehat.dto.Location.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String country;
    private List<AddressExtension> extension;
    private String city;
    private List<String> line;
    private String use;
    private String postalCode;
}
