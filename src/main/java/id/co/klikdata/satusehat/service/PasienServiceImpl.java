package id.co.klikdata.satusehat.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

import id.co.klikdata.satusehat.dto.PatientResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PasienServiceImpl implements PasienService {
    private final SatuSehatService satuSehatService;

    @Override
    public PatientResponse getPasienByNik(String nik) {
        return satuSehatService.getPasientByNik(nik);
    }

    @Override
    public ResponseEntity<JsonNode> getPasienByNameGenderAndBirthdate(String name, String gender, String birthdate)
            throws JsonMappingException, JsonProcessingException {
        return satuSehatService.getPasienByNameGenderAndBirthdate(name, gender, birthdate);
    }

}
