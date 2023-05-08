package id.co.klikdata.satusehat.dto.Location.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    private long altitude;
    private double latitude;
    private double longitude;
}
