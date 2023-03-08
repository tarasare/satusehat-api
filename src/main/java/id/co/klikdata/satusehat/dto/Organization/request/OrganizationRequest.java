package id.co.klikdata.satusehat.dto.Organization.request;

import java.util.List;

import lombok.Data;

@Data
public class OrganizationRequest {
    private String resourceType;
    private boolean active;
    private List<Identifier> identifier;
    private List<Type> type;
    private String name;
    private List<Telecom> telecom;
    private List<Address> address;
    private PartOf partOf;
}
