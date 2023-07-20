package id.co.klikdata.satusehat.controller;

import id.co.klikdata.satusehat.dto.Encounter.response.EncounterResponse;
import id.co.klikdata.satusehat.entity.Pendaftaran;
import id.co.klikdata.satusehat.service.EncounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encounter")
@RequiredArgsConstructor
public class EncounterController {

    private final EncounterService encounterService;

    @PostMapping("/{nomor}")
    public EncounterResponse create(@PathVariable String nomor) {
        return encounterService.create(nomor);
    }

}
