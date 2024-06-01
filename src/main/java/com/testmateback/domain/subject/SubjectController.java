package com.testmateback.domain.subject;

import com.testmateback.domain.subject.dto.*;
import com.testmateback.domain.subject.entity.Subject;
import com.testmateback.domain.subject.service.SubjectService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    public ResponseEntity<ResponseMessage> createSubject(@ModelAttribute CreateSubject createSubject) throws IOException {
        Subject newSubject = subjectService.createSubject(createSubject);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    /*
        @ 홈에서 과목 편집
        patch api/subject/name/:subjectId
    */
    @PatchMapping("name/{subjectId}")
        public ResponseEntity<ResponseMessage> updateSubject(@PathVariable Long subjectId, @ModelAttribute UpdateSubjectReq updateSubjectReq){
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
    @GetMapping("list/{grade}")
    public List<SubjectInfoDTO> getSubjectsInfo(@PathVariable int grade) {
        return subjectService.getSubjectInfo(grade);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<SubjectInfoDTO> getSubjectInfoById(@PathVariable Long subjectId) {
        SubjectInfoDTO subjectInfoDTO = subjectService.getSubjectInfoById(subjectId);
        return new ResponseEntity<>(subjectInfoDTO, HttpStatus.OK);
    }

    /*
        @ 홈에서 학년정보와 과목을 입력받아서 과목정보를 불러오기
        get  /api/subject/home/:subjectId
     */
    @GetMapping("home/{subjectId}")
    public SubjectDetailsDTO getSubjectDetails(@PathVariable Long subjectId) {
        return subjectService.getSubjectDetailsById(subjectId);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<ResponseMessage> deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_DELETE.getMessage()));
    }
}