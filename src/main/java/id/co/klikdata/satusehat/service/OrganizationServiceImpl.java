package id.co.klikdata.satusehat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import id.co.klikdata.satusehat.dao.GrupRuanganDao;
import id.co.klikdata.satusehat.dao.SettingsDao;
import id.co.klikdata.satusehat.dto.Organization.request.Address;
import id.co.klikdata.satusehat.dto.Organization.request.Coding;
import id.co.klikdata.satusehat.dto.Organization.request.Extension;
import id.co.klikdata.satusehat.dto.Organization.request.Identifier;
import id.co.klikdata.satusehat.dto.Organization.request.OrganizationRequest;
import id.co.klikdata.satusehat.dto.Organization.request.PartOf;
import id.co.klikdata.satusehat.dto.Organization.request.Telecom;
import id.co.klikdata.satusehat.dto.Organization.request.Type;
import id.co.klikdata.satusehat.dto.Organization.request.ValueExtension;
import id.co.klikdata.satusehat.dto.Organization.response.OrganizationResponse;
import id.co.klikdata.satusehat.entity.GrupRuangan;
import id.co.klikdata.satusehat.entity.Settings;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final RestTemplate restTemplate;
    private final SatuSehatService satuSehatService;
    private final GrupRuanganDao grupRuanganDao;
    private final SettingsDao settingsDao;

    @Override
    public OrganizationResponse addGroupRuangan(Integer idGroup) {
        Settings settings = settingsDao.findAll().get(0);
        GrupRuangan data = grupRuanganDao.findById(idGroup).get();

        OrganizationRequest req = new OrganizationRequest();
        req.setResourceType("Organization");
        req.setActive(true);
        List<Identifier> identifiers = new ArrayList<>();
        identifiers.add(new Identifier("official",
                "http://sys-ids.kemkes.go.id/organization/" + settings.getOrganizationId(), settings.getNama()));
        req.setIdentifier(identifiers);
        List<Type> types = new ArrayList<>();
        List<Coding> codings = new ArrayList<>();
        codings.add(
                new Coding("http://terminology.hl7.org/CodeSystem/organization-type", "dept", "Hospital Department"));
        types.add(new Type(codings));
        req.setType(types);
        req.setName(data.getNamaGrupRuangan());
        List<Telecom> telecom = new ArrayList<>();
        telecom.add(new Telecom("phone", settings.getTelp(), "work"));
        telecom.add(new Telecom("email", settings.getEmail(), "work"));
        telecom.add(new Telecom("url", settings.getWebsite(), "work"));
        req.setTelecom(telecom);
        List<Address> address = new ArrayList<>();
        String[] line = { settings.getAlamat() };
        List<Extension> extension = new ArrayList<>();
        List<ValueExtension> extensionVal = new ArrayList<>();
        extensionVal.add(new ValueExtension("province", settings.getProvinsi()));
        extensionVal.add(new ValueExtension("ci ty", settings.getKabupaten()));
        extensionVal.add(new ValueExtension("district", settings.getKecamatan()));
        extensionVal.add(new ValueExtension("village", settings.getKelurahan()));
        extension.add(
                new Extension("https://fhir.kemkes.go.id/r4/StructureDefinition/administrativeCode", extensionVal));
        address.add(new Address("work", "both", line, settings.getNamaKabKota(), settings.getKode(), "ID", extension));
        req.setAddress(address);
        req.setPartOf(new PartOf("Organization/" + settings.getOrganizationId()));

        String token = satuSehatService.getAccessToken().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<OrganizationRequest> request = new HttpEntity<>(req, headers);
        ResponseEntity<OrganizationResponse> response = restTemplate.exchange(
                SatuSehat.URL_ORGANIZATION,
                HttpMethod.POST, request,
                OrganizationResponse.class);

        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            data.setIdIhs(response.getBody().getId());
            grupRuanganDao.save(data);
        }

        return response.getBody();
    }

}
