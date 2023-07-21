package id.co.klikdata.satusehat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import id.co.klikdata.satusehat.dto.PractitionerResponse;
import id.co.klikdata.satusehat.service.PractitionerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/practition")
@RequiredArgsConstructor
public class PractitionerController {
    private final PractitionerService dokterService;

    @PostMapping("/{nik}")
    public ResponseEntity<PractitionerResponse> getDokterByNik(@PathVariable("nik") String nik) {
        return ResponseEntity.ok(dokterService.getDokterByNik(nik));
    }
}
