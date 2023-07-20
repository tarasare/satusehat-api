package id.co.klikdata.satusehat.dto.Wilayah;

import lombok.Data;

@Data
public class DataResponse<T> {
    private Integer status;
    private String message;
    private T data;
}
