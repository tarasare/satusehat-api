package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dto.PatientResponse;
import id.co.klikdata.satusehat.dto.PractitionerResponse;

public interface SatuSehatService {
    PatientResponse getPasientByNik(String nik);

    PractitionerResponse getDokterByNik(String nik);
}
