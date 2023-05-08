package id.co.klikdata.satusehat.controller;

import id.co.klikdata.satusehat.dto.Location.response.LocationResponse;
import id.co.klikdata.satusehat.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping("/{idRuangan}")
    public LocationResponse addLocation(@PathVariable("idRuangan") Long idRuangan) {
        return locationService.addLocation(idRuangan);
    }
}
