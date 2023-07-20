package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dao.UsersDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncounterServiceImpl implements EncounterService {
    private final UsersDao usersDao;

}
