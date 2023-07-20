package id.co.klikdata.satusehat.dto.Wilayah;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class KecamatanDto {
    private Long id;
    private String kode;
    private String nama;
    @JsonProperty("id_kabupaten")
    private Long idKabupaten;
}
