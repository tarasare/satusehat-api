package id.co.klikdata.satusehat.dto.Organization.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identifier {
    private String use;
    private String system;
    private String value;
}
