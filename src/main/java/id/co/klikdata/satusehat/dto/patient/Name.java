package id.co.klikdata.satusehat.dto.patient;

import java.util.List;

import lombok.Data;

@Data
public class Name {
    private String family;
    private List<String> given;
    private List<String> suffix;
    private String text;
    private String use;
}
