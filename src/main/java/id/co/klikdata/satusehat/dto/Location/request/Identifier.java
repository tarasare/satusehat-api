package id.co.klikdata.satusehat.dto.Location.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identifier {
    private String system;
    private String value;
}