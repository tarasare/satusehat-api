package id.co.klikdata.satusehat.dto.patient;

import java.util.List;

import lombok.Data;

@Data
public class Resource {
    private boolean active;
    private List<Communication> communication;
    private boolean deceasedBoolean;
    private String gender;
    private String id;
    private List<Identifier> identifier;
    private Meta meta;
    private boolean multipleBirthBoolean;
    private List<Name> name;
    private String resourceType;
}
