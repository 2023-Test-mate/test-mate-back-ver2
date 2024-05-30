package com.testmateback.domain.wrongnote.controller;

import com.testmateback.domain.wrongnote.dto.CreateReasonReq;
import com.testmateback.domain.wrongnote.entity.Reason;
import com.testmateback.domain.wrongnote.service.ReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reasons")
public class ReasonController {
    private final ReasonService reasonService;

    @Autowired
    public ReasonController(ReasonService reasonService) {
        this.reasonService = reasonService;
    }

    /*
        @ 오답노트 - 오답 이유 추가
        post api/reasons
     */
    @PostMapping
    public Reason createReason(@RequestBody CreateReasonReq createReasonReq){
        return reasonService.createRange(createReasonReq);
    }

    /*
        @ 오답노트 - 모든 이유 가져오기
        get api/reasons
     */
    @GetMapping
    public List<Reason> getReasonsByUserId() {
        return reasonService.getReasonsByUserId();
    }

    /*
        @ 오답노트 - 오답이유 수정하기
        put api/reasons:reasonId
     */
    @PutMapping("/{reasonId}")
    public Reason updateReason(@PathVariable int reasonId, @RequestBody Reason reason){
        return reasonService.updateReason(reasonId, reason);
    }

    /*
        @ 오답노트 - 오답 이유 삭제하기
        delete api/reason:reasonId
     */
    @DeleteMapping("/{reasonId}")
    public void deleteReason(@PathVariable int reasonId) {
        reasonService.deleteReason(reasonId);
    }

}
