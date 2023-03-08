package id.co.klikdata.satusehat.service;

import org.springframework.http.ResponseEntity;

import id.co.klikdata.satusehat.dto.Organization.response.OrganizationResponse;

public interface OrganizationService {

    OrganizationResponse addGroupRuangan(Integer idGroup);

}
