package id.co.klikdata.satusehat.dto.practitioner;

import java.util.List;

import lombok.Data;

@Data
public class Practitioner {
    private String gender;
    private String id;
    private List<Identifier> identifier;
    private Meta meta;
    private List<Name> name;
}
