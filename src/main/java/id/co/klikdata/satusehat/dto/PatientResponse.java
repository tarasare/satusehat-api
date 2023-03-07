package id.co.klikdata.satusehat.dto;

import java.util.List;

import id.co.klikdata.satusehat.dto.patient.Entry;
import lombok.Data;

@Data
public class PatientResponse {
    private String resourceType;
    private int total;
    private String type;
    private List<Entry> entry;
}
