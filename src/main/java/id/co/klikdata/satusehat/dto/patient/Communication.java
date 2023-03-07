package id.co.klikdata.satusehat.dto.patient;

import lombok.Data;

@Data
public class Communication {
    private Language language;
    private boolean preferred;
}
