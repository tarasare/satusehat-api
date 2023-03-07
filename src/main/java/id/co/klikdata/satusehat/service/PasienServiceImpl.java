package id.co.klikdata.satusehat.service;

import org.springframework.stereotype.Service;

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

}
