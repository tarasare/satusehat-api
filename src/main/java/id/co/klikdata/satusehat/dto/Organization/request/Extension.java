package id.co.klikdata.satusehat.dto.Organization.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Extension {
    private String url;
    private List<ValueExtension> extension;
}
