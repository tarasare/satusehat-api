package id.co.klikdata.satusehat.dto.Location.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {
    private OffsetDateTime lastUpdated;
    private String versionId;
}
