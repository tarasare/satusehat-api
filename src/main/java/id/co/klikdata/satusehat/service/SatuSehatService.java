package id.co.klikdata.satusehat.service;

import org.springframework.http.ResponseEntity;

import id.co.klikdata.satusehat.dto.PatientResponse;
import id.co.klikdata.satusehat.dto.PractitionerResponse;
import id.co.klikdata.satusehat.dto.TokenResponse;

public interface SatuSehatService {
    TokenResponse getAccessToken();

    PatientResponse getPasientByNik(String nik);

    PractitionerResponse getDokterByNik(String nik);

}
