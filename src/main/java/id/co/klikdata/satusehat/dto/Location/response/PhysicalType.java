package id.co.klikdata.satusehat.dto.Location.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalType {
    private List<Coding> coding;
}
