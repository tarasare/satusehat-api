package id.co.klikdata.satusehat.dto.Encounter.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
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
    public static class ClassDetails {
        private String system;
        private String code;
        private String display;
    }

    @Data
    public static class Subject {
        private String reference;
        private String display;
    }

    @Data
    public static class Participant {
        private List<Type> type;
        private Individual individual;
    }

    @Data
    public static class Type {
        private List<Coding> coding;
    }

    @Data
    public static class Coding {
        private String system;
        private String code;
        private String display;
    }

    @Data
    public static class Individual {
        private String reference;
        private String display;
    }

    @Data
    public static class Period {
        private String start;
    }

    @Data
    public static class LocationWrapper {
        private Location location;
    }

    @Data
    public static class Location {
        private String reference;
        private String display;
    }

    @Data
    public static class StatusHistory {
        private String status;
        private Period period;
    }

    @Data
    public static class ServiceProvider {
        private String reference;
    }

    @Data
    public static class Identifier {
        private String system;
        private String value;
    }

}
