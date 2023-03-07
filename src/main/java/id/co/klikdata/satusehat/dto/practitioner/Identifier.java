package id.co.klikdata.satusehat.dto.practitioner;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Identifier {
    private String system;
    private String value;

    @JsonProperty("use")
    private String identifierUse;
}
