package id.co.klikdata.satusehat.dto.Location.response;

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
