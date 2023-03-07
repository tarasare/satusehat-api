package id.co.klikdata.satusehat.dto.patient;

import lombok.Data;

@Data
public class Identifier {
    private String system;
    private String use;
    private String value;
}
