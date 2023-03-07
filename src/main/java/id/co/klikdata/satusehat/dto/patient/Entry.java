package id.co.klikdata.satusehat.dto.patient;

import lombok.Data;

@Data
public class Entry {
    private String fullUrl;
    private Resource resource;
    private Search search;
}
