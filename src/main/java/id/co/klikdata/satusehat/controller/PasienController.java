package id.co.klikdata.satusehat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.klikdata.satusehat.dto.PatientResponse;
import id.co.klikdata.satusehat.service.PasienService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pasien")
@RequiredArgsConstructor
public class PasienController {
    private final PasienService pasienService;

    @GetMapping("/{nik}")
    public ResponseEntity<PatientResponse> getPasienByNik(@PathVariable("nik") String nik) {
        return ResponseEntity.ok(pasienService.getPasienByNik(nik));
    }
}
