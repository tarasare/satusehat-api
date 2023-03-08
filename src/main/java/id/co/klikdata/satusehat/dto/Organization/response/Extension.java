package id.co.klikdata.satusehat.dto.Organization.response;

import lombok.Data;

@Data
public class Extension {
    private String url;
    private ValueExtension[] extension;
}