// LocationRequest.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package id.co.klikdata.satusehat.dto.Location.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    private String mode;
    private List<Identifier> identifier;
    private ManagingOrganization managingOrganization;
    private String name;
    private PhysicalType physicalType;
    private String description;
    private List<Telecom> telecom;
    private Position position;
    private String resourceType;
    private String status;
}