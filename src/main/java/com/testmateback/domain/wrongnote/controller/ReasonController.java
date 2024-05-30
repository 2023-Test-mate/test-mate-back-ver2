package com.testmateback.domain.wrongnote.controller;

import com.testmateback.domain.wrongnote.dto.CreateReasonReq;
import com.testmateback.domain.wrongnote.entity.Reason;
import com.testmateback.domain.wrongnote.service.ReasonService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseMessage> createReason(@RequestBody CreateReasonReq createReasonReq){
        reasonService.createRange(createReasonReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
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
    public ResponseEntity<ResponseMessage> updateReason(@PathVariable int reasonId, @RequestBody Reason reason){
        reasonService.updateReason(reasonId, reason);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

    /*
        @ 오답노트 - 오답 이유 삭제하기
        delete api/reason:reasonId
     */
    @DeleteMapping("/{reasonId}")
    public ResponseEntity<ResponseMessage> deleteReason(@PathVariable int reasonId) {
        reasonService.deleteReason(reasonId);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_DELETE.getMessage()));
    }

}
