package id.co.klikdata.satusehat.service;

import id.co.klikdata.satusehat.dto.Condition.response.ConditionResponse;

public interface ConditionService {
    ConditionResponse create(String nomor);
}
