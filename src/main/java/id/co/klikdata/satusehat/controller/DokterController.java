package id.co.klikdata.satusehat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.klikdata.satusehat.dto.PractitionerResponse;
import id.co.klikdata.satusehat.service.DokterService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dokter")
@RequiredArgsConstructor
public class DokterController {
    private final DokterService dokterService;

    @GetMapping("/{nik}")
    public ResponseEntity<PractitionerResponse> getDokterByNik(@PathVariable("nik") String nik) {
        return ResponseEntity.ok(dokterService.getDokterByNik(nik));
    }
}
