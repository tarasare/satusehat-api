package id.co.klikdata.satusehat.dto.Observation.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObservationRequest {
    private String resourceType;
    private String status;
    private List<Category> category;
    private Code code;
    private Subject subject;
    private List<Performer> performer;
    private Encounter encounter;
    private String effectiveDateTime;
    private String issued;
    private ValueQuantity valueQuantity;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Category {
        private List<Coding> coding;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Code {
        private List<Coding> coding;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Subject {
        private String reference;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Performer {
        private String reference;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Encounter {
        private String reference;
        private String display;
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
    public static class ValueQuantity {
        private int value;
        private String unit;
        private String system;
        private String code;
    }
}
