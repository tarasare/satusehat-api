package id.co.klikdata.satusehat.dto.Condition.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionRequest {
    private String resourceType;
    private ClinicalStatus clinicalStatus;
    private List<CategoryWrapper> category;
    private CodeWrapper code;
    private Subject subject;
    private EncounterWrapper encounter;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ClinicalStatus {
        private List<Coding> coding;
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
    public static class CodeWrapper {
        private List<Coding> coding;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Coding {
        private String system;
        private String code;
        private String display;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Subject {
        private String reference;
        private String display;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EncounterWrapper {
        private String reference;
        private String display;
    }
}
