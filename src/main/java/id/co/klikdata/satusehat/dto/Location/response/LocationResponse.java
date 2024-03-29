// LocationResponse.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package id.co.klikdata.satusehat.dto.Location.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private List<Identifier> identifier;
    private Address address;
    private PhysicalType physicalType;
    private String description;
    private String mode;
    private ManagingOrganization managingOrganization;
    private Meta meta;
    private String name;
    private List<Telecom> telecom;
    private UUID id;
    private Position position;
    private String resourceType;
    private String status;
}