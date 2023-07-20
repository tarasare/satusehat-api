package id.co.klikdata.satusehat.dto.Encounter.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EncounterResponse {
    @JsonProperty("class")
    private ClassDetails classDetails;
    private String id;
    private List<Identifier> identifier;
    private List<LocationWrapper> location;
    private Meta meta;
    private List<Participant> participant;
    private Period period;
    private String resourceType;
    private ServiceProvider serviceProvider;
    private String status;
    private List<StatusHistory> statusHistory;
    private Subject subject;

    @Data
    public static class ClassDetails {
        private String code;
        private String display;
        private String system;
    }

    @Data
    public static class Identifier {
        private String system;
        private String value;
    }

    @Data
    public static class LocationWrapper {
        private Location location;
    }

    @Data
    public static class Location {
        private String display;
        private String reference;
    }

    @Data
    public static class Meta {
        private String lastUpdated;
        private String versionId;
    }

    @Data
    public static class Participant {
        private Individual individual;
        private List<Type> type;
    }

    @Data
    public static class Individual {
        private String display;
        private String reference;
    }

    @Data
    public static class Type {
        private List<Coding> coding;
    }

    @Data
    public static class Coding {
        private String code;
        private String display;
        private String system;
    }

    @Data
    public static class Period {
        private String start;
    }

    @Data
    public static class ServiceProvider {
        private String reference;
    }

    @Data
    public static class StatusHistory {
        private Period period;
        private String status;
    }

    @Data
    public static class Subject {
        private String display;
        private String reference;
    }
}
