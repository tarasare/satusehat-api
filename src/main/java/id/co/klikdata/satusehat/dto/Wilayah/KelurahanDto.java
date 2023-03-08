package id.co.klikdata.satusehat.dto.Wilayah;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KelurahanDto {
    @JsonProperty("kode_bps")
    private String kodeBps;

    @JsonProperty("nama_bps")
    private String namaBps;

    @JsonProperty("kode_dagri")
    private String kodeDagri;

    @JsonProperty("nama_dagri")
    private String namaDagri;
}
