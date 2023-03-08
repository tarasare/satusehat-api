package id.co.klikdata.satusehat.dto.Organization.response;

import java.util.List;

import lombok.*;

@Data
public class OrganizationResponse {
    private List<Identifier> identifier;
    private PartOf partOf;
    private List<Address> address;
    private Meta meta;
    private String name;
    private Boolean active;
    private List<Telecom> telecom;
    private String id;
    private List<Type> type;
    private String resourceType;
}
