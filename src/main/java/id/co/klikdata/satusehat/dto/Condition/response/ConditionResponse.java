package id.co.klikdata.satusehat.dto.Condition.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionResponse {
    private String id;
    private Meta meta;
    private String resourceType;
    private List<CategoryWrapper> category;
    private ClinicalStatus clinicalStatus;
    private CodeWrapper code;
    private Subject subject;
    private EncounterWrapper encounter;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Meta {
        private String lastUpdated;
        private String versionId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryWrapper {
        private List<Coding> coding;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ClinicalStatus {
        private List<Coding> coding;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CodeWrapper {
        private List<Coding> coding;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Coding {
        private String code;
        private String display;
        private String system;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Subject {
        private String display;
        private String reference;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EncounterWrapper {
        private String display;
        private String reference;
    }
}
