package id.co.klikdata.satusehat.dto.patient;

import java.util.List;

import lombok.Data;

@Data
public class Meta {
    private String lastUpdated;
    private List<String> profile;
    private String versionId;
}
