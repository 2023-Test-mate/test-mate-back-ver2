package com.testmateback.dTestmate.subject;

import com.testmateback.dTestmate.subject.dto.CreateFailReq;
import com.testmateback.dTestmate.subject.dto.CreateSubject;
import com.testmateback.dTestmate.subject.dto.CreateTestRecordReq;
import com.testmateback.dTestmate.subject.dto.UpdateSubjectReq;
import com.testmateback.dTestmate.subject.entity.Subject;
import com.testmateback.dTestmate.subject.service.SubjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Subject> createSubject(@RequestBody CreateSubject createSubject) {
        Subject newSubject = subjectService.createSubject(createSubject);
        return ResponseEntity.ok(newSubject);
    }

    /*
        @ 홈에서 과목 편집
        patch api/subject/name/:subjectId
    */
    @PatchMapping("name/{subjectId}")
        public ResponseEntity<Subject> updateSubject(@PathVariable Long subjectId, @RequestBody UpdateSubjectReq updateSubjectReq){
        Subject updateSubject = subjectService.updateSubject(subjectId, updateSubjectReq);
        return ResponseEntity.ok(updateSubject);
    }

    /*
        @ 홈에서 시험 기록
        patch : patch api/subject/record/:subjectId
    */
    @PatchMapping("record/{subjectId}")
    public ResponseEntity<Subject> updateTestRecord(@PathVariable Long subjectId, @RequestBody CreateTestRecordReq createTestRecordReq) {
        Subject updatedRecord = subjectService.updateTestRecord(subjectId, createTestRecordReq);
        return ResponseEntity.ok(updatedRecord);
    }

    /*
        @ 홈에서 실패요소 선택
        patch api/subject/fail/:subjectId
    */
    @PatchMapping("fail/{subjectId}")
    public ResponseEntity<Subject> updateFail(@PathVariable Long subjectId, @RequestBody CreateFailReq createFailReq) {
        Subject updateFailed = subjectService.updateFail(subjectId, createFailReq);
        return ResponseEntity.ok(updateFailed);
    }

}