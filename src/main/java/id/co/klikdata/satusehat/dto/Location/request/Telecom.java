package id.co.klikdata.satusehat.dto.Location.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telecom {
    private String system;
    private String use;
    private String value;

}
