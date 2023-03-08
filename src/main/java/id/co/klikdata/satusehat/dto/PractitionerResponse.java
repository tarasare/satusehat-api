package id.co.klikdata.satusehat.dto;

import java.util.List;

import id.co.klikdata.satusehat.dto.practitioner.Entry;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PractitionerResponse {
    private List<Entry> entry;
    private String resourceType;
    private int total;
    private String type;
}
