package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dto.PractitionerResponse;

public interface DokterService {

    PractitionerResponse getDokterByNik(String nik);

}
