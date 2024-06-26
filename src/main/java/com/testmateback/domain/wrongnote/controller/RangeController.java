package com.testmateback.domain.wrongnote.controller;

import com.testmateback.domain.wrongnote.dto.CreateRangeReq;
import com.testmateback.domain.wrongnote.entity.Range;
import com.testmateback.domain.wrongnote.service.RangeService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/ranges")
public class RangeController {

    private final RangeService rangeService;

    @Autowired
    public RangeController(RangeService rangeService) {
        this.rangeService = rangeService;
    }

    /*
        @ 오답노트 - 범위 추가
        post api/ranges
     */
    @PostMapping
    public ResponseEntity<ResponseMessage> createRange(@RequestBody CreateRangeReq createRangeReq) {
        rangeService.createRange(createRangeReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    /*
        @ 오답노트 - 모든 범위 가져오기
        get api/ranges
     */
    @GetMapping
    public List<Range> getRangesByUserId() {
        return rangeService.getRangesByUserId();
    }

    /*
        @ 오답노트 - 범위 수정하기
        put api/ranges:rangeId
     */
    @PutMapping("/{rangeId}")
    public ResponseEntity<ResponseMessage> updateRange(@PathVariable int rangeId, @RequestBody Range range) {
        rangeService.updateRange(rangeId, range);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

    /*
       @ 오답노트 - 범위 삭제하기
       delete api/ranges:rangeId
    */
    @DeleteMapping("/{rangeId}")
    public ResponseEntity<ResponseMessage> deleteRange(@PathVariable int rangeId) {
        rangeService.deleteRange(rangeId);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_DELETE.getMessage()));
    }
}