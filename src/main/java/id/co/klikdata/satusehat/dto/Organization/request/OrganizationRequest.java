package id.co.klikdata.satusehat.dto.Organization.request;

import lombok.Data;

@Data
public class OrganizationRequest {
    private String resourceType;
    private boolean active;
    private Identifier[] identifier;
    private Type[] type;
    private String name;
    private Telecom[] telecom;
    private Address[] address;
    private PartOf partOf;
}
