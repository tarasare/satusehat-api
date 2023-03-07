package id.co.klikdata.satusehat.dto.patient;

import java.util.List;

import lombok.Data;

@Data
public class Language {
    private List<Coding> coding;
    private String text;
}
