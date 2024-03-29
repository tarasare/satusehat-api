package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.GrupRuanganDao;
import id.co.klikdata.satusehat.dao.RuanganDao;
import id.co.klikdata.satusehat.dao.SettingsDao;
import id.co.klikdata.satusehat.dto.Location.request.*;
import id.co.klikdata.satusehat.dto.Location.response.LocationResponse;
import id.co.klikdata.satusehat.dto.Organization.request.ValueExtension;
import id.co.klikdata.satusehat.entity.Ruangan;
import id.co.klikdata.satusehat.entity.Settings;
import id.co.klikdata.satusehat.utils.SatuSehat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final SettingsDao settingsDao;
    private final GrupRuanganDao grupRuanganDao;
    private final RuanganDao ruanganDao;
    private final SatuSehatService satuSehatService;
    private final RestTemplate restTemplate;

    @Override
    public LocationResponse addLocation(Long idRuangan) {
        Settings settings = settingsDao.findAll().get(0);
        Ruangan data = ruanganDao.findById(idRuangan).get();

        LocationRequest req = new LocationRequest();
        req.setResourceType("Location");
        req.setStatus("active");
        req.setMode("instance");
        req.setName(data.getNamaRuangan());
        req.setDescription("");
        List<Identifier> identifier = new ArrayList<>();
        identifier.add(new Identifier("http://sys-ids.kemkes.go.id/location/" + data.getId(), ""));
        req.setIdentifier(identifier);

        List<Telecom> telecom = new ArrayList<>();
        telecom.add(new Telecom("phone",  "work", settings.getTelp()));
        telecom.add(new Telecom("email",  "work", settings.getEmail()));
        telecom.add(new Telecom("url", "work", settings.getWebsite()));
        req.setTelecom(telecom);

        String[] line = { settings.getAlamat() };
        List<AddressExtension> extension = new ArrayList<>();
        List<ExtensionExtension> extensions = new ArrayList<>();
        List<ValueExtension> extensionVal = new ArrayList<>();
        extensionVal.add(new ValueExtension(settings.getProvinsi().getNamaProvinsi(), settings.getProvinsi().getIdKemendagri()));
        extensionVal.add(new ValueExtension(settings.getKabupaten().getNamaKabkota(), settings.getKabupaten().getIdKemendagri()));
        extensionVal.add(new ValueExtension(settings.getKecamatan().getNamaKecamatan(), settings.getKecamatan().getIdKemendagri()));
        extensionVal.add(new ValueExtension(settings.getKelurahan().getNamaDesa(), settings.getKelurahan().getIdKemendagri()));
        extension.add(new AddressExtension("https://fhir.kemkes.go.id/r4/StructureDefinition/administrativeCode", extensions));
        Address address = new Address();
        address.setUse("work");
        address.setLine(Arrays.stream(line).toList());
        address.setCity(settings.getKabupaten().getNamaKabkota());
        address.setPostalCode(settings.getKode());
        address.setCountry("ID");
        address.setExtension(extension);

        req.setAddress(address);
        List<Coding> codings = new ArrayList<>();
        codings.add(new Coding("http://terminology.hl7.org/CodeSystem/location-physical-type", "ro", "Room"));
        req.setPhysicalType(new PhysicalType(codings));
        req.setPosition(new Position(0, 0, 0));
        req.setManagingOrganization(new ManagingOrganization("Organization/" + data.getGrupRuangan().getIdIhs()));

        String token = satuSehatService.getAccessToken().getAccessToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);
        HttpEntity<LocationRequest> request = new HttpEntity<>(req, headers);
        ResponseEntity<LocationResponse> response = restTemplate.exchange(
                satuSehatService.getBaseUrl() + "/fhir-r4/v1/Location",
                HttpMethod.POST, request,
                LocationResponse.class);

        if (response.getStatusCode().equals(HttpStatus.CREATED)) {
            data.setIdIhs(String.valueOf(response.getBody().getId()));
            ruanganDao.save(data);
        }

        return response.getBody();
    }
}
