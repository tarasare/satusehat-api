package id.co.klikdata.satusehat.controller;

import id.co.klikdata.satusehat.dto.Condition.response.ConditionResponse;
import id.co.klikdata.satusehat.service.ConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition")
@RequiredArgsConstructor
public class ConditionController {
    private final ConditionService conditionService;

    @PostMapping("/{nomor}")
    public ConditionResponse create(@PathVariable String nomor) {
        return conditionService.create(nomor);
    }
}
