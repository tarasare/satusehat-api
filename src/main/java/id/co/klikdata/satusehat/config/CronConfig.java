package id.co.klikdata.satusehat.config;

import id.co.klikdata.satusehat.dao.GrupRuanganDao;
import id.co.klikdata.satusehat.dao.PendaftaranDao;
import id.co.klikdata.satusehat.dao.RuanganDao;
import id.co.klikdata.satusehat.dao.UsersDao;
import id.co.klikdata.satusehat.entity.GrupRuangan;
import id.co.klikdata.satusehat.entity.Pendaftaran;
import id.co.klikdata.satusehat.entity.Ruangan;
import id.co.klikdata.satusehat.entity.Users;
import id.co.klikdata.satusehat.service.LocationService;
import id.co.klikdata.satusehat.service.OrganizationService;
import id.co.klikdata.satusehat.service.PasienService;
import id.co.klikdata.satusehat.service.PractitionerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
public class CronConfig {
    private final UsersDao usersDao;
    private final GrupRuanganDao grupRuanganDao;
    private final RuanganDao ruanganDao;
    private final PendaftaranDao pendaftaranDao;
    private final PasienService pasienService;
    private final PractitionerService practitionerService;
    private final OrganizationService organizationService;
    private final LocationService locationService;


    @Async
    @Scheduled(fixedRate = 50000)
    public void pasienCron() {
        System.out.println("Cron Pasien Running!");
        List<Users> data = usersDao.findByGrupUserAndIdPasienIhs(2, null);
        data.forEach(item -> {
            System.out.println(item.getNamaUser());
            pasienService.getPasienByNik(item.getNoIdentitas());
        });
    }

    @Async
    @Scheduled(fixedRate = 10000)
    public void organizationCron() {
        System.out.println("Cron Organization Running!");
        List<GrupRuangan> data = grupRuanganDao.findByIdIhs(null);
        data.forEach(item -> {
            System.out.println(item.getNamaGrupRuangan());
            organizationService.addGroupRuangan(Integer.valueOf(item.getId().toString()));
        });
    }


    @Async
    @Scheduled(fixedRate = 5000)
    public void practitionerCron() {
        System.out.println("Cron Practition Running!");
        List<Users> data = usersDao.findByGrupUserAndIsdefaultAndIdPetugasIhs(1, 0,null);
        data.forEach(item -> {
            System.out.println(item.getNamaUser());
            practitionerService.getDokterByNik(item.getNoIdentitas());
        });
    }

    @Async
    @Scheduled(fixedRate = 15000)
    public void locationCron() {
        System.out.println("Cron Location Running!");
        List<Ruangan> data = ruanganDao.findByIsactiveAndIdIhs(1, null);
        data.forEach(item -> {
            System.out.println(item.getNamaRuangan());
            locationService.addLocation(item.getId());
        });
    }

    @Async
    @Scheduled(fixedRate = 16000)
    public void encounterCron() {
        System.out.println("Cron Encounter Running!");
//        PageRequest pageRequest = PageRequest.of(3, 30);
        List<Pendaftaran> data = pendaftaranDao.findAll();
        data.forEach(item -> {
            System.out.println(item.getNoRegister());
        });
    }

}
