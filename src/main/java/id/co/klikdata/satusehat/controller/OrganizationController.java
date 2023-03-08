package id.co.klikdata.satusehat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.klikdata.satusehat.dto.Organization.response.OrganizationResponse;
import id.co.klikdata.satusehat.service.OrganizationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/organization")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    @PostMapping("/{idGroup}")
    public OrganizationResponse addGroupRuangan(@PathVariable("idGroup") Integer idGroup) {
        return organizationService.addGroupRuangan(idGroup);
    }
}
