package id.co.klikdata.satusehat.dto.Encounter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EncounterRequest {
    private String resourceType;
    private String status;

    @JsonProperty("class")
    private ClassDetails encounterClass;
    private Subject subject;
    private List<Participant> participant;
    private Period period;
    private List<LocationWrapper> location;
    private List<StatusHistory> statusHistory;
    private ServiceProvider serviceProvider;
    private List<Identifier> identifier;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ClassDetails {
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
    public static class Participant {
        private List<Type> type;
        private Individual individual;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Type {
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
    public static class Individual {
        private String reference;
        private String display;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Period {
        private String start;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LocationWrapper {
        private Location location;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Location {
        private String reference;
        private String display;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StatusHistory {
        private String status;
        private Period period;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ServiceProvider {
        private String reference;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Identifier {
        private String system;
        private String value;
    }

}
