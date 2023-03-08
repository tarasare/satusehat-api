package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dto.PatientResponse;

public interface PasienService {

    PatientResponse getPasienByNik(String nik);

}
