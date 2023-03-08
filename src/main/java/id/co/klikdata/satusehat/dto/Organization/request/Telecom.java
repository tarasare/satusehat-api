package id.co.klikdata.satusehat.dto.Organization.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telecom {
    private String system;
    private String value;
    private String use;
}
