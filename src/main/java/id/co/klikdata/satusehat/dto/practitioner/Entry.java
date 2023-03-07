package id.co.klikdata.satusehat.dto.practitioner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
    private String fullUrl;
    private Practitioner resource;
    private Search search;
}
