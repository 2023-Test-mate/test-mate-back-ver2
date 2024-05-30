package com.testmateback.domain.subject;

import com.testmateback.domain.subject.dto.*;
import com.testmateback.domain.subject.entity.Subject;
import com.testmateback.domain.subject.service.SubjectService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    /*
        @ 홈에서 과목생성
        post api/subject
     */
    @PostMapping
    public ResponseEntity<ResponseMessage> createSubject(@RequestBody CreateSubject createSubject) {
        Subject newSubject = subjectService.createSubject(createSubject);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    /*
        @ 홈에서 과목 편집
        patch api/subject/name/:subjectId
    */
    @PatchMapping("name/{subjectId}")
        public ResponseEntity<ResponseMessage> updateSubject(@PathVariable Long subjectId, @RequestBody UpdateSubjectReq updateSubjectReq){
        Subject updateSubject = subjectService.updateSubject(subjectId, updateSubjectReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

    /*
        @ 홈에서 시험 기록
        patch : patch api/subject/record/:subjectId
    */
    @PatchMapping("record/{subjectId}")
    public ResponseEntity<ResponseMessage> updateTestRecord(@PathVariable Long subjectId, @RequestBody CreateTestRecordReq createTestRecordReq) {
        Subject updatedRecord = subjectService.updateTestRecord(subjectId, createTestRecordReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

    /*
        @ 홈에서 실패요소 선택
        patch api/subject/fail/:subjectId
    */
    @PatchMapping("fail/{subjectId}")
    public ResponseEntity<ResponseMessage> updateFail(@PathVariable Long subjectId, @RequestBody CreateFailReq createFailReq) {
        Subject updateFailed = subjectService.updateFail(subjectId, createFailReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

    /*
        @ 홈에서 로그인한 유저와 학년에 대한 과목 리스트
        get /api/subject/:grade
     */
    @GetMapping("/{grade}")
    public List<SubjectInfoDTO> getSubjectInfo(@PathVariable int grade) {
        return subjectService.getSubjectInfo(grade);
    }

    /*
        @ 홈에서 학년정보와 과목을 입력받아서 과목정보를 불러오기
        get  /api/subject/home/:subjectId
     */
    @GetMapping("home/{subjectId}")
    public SubjectDetailsDTO getSubjectDetails(@PathVariable Long subjectId) {
        return subjectService.getSubjectDetailsById(subjectId);
    }
}