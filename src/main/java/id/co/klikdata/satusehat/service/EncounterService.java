package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dto.Encounter.response.EncounterResponse;
import id.co.klikdata.satusehat.entity.Pendaftaran;

public interface EncounterService {
    EncounterResponse create(String nomor);
}
