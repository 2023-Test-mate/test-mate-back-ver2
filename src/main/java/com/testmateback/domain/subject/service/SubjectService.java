package com.testmateback.domain.subject.service;

import com.testmateback.domain.calendar.entity.Calendar;
import com.testmateback.domain.calendar.repository.CalendarRepository;
import com.testmateback.domain.subject.dto.*;
import com.testmateback.domain.subject.entity.Exam;
import com.testmateback.domain.subject.entity.Subject;
import com.testmateback.domain.subject.repository.SubjectRepository;
import com.testmateback.domain.user.repository.UserRepository;
import com.testmateback.domain.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final CalendarRepository calendarRepository;
    private final UserRepository userRepository;
    private final HttpSession session;

    public SubjectService(SubjectRepository subjectRepository, CalendarRepository calendarRepository, UserRepository userRepository, HttpSession session) {
        this.subjectRepository = subjectRepository;
        this.calendarRepository = calendarRepository;
        this.userRepository = userRepository;
        this.session = session;
    }

    // 홈 - 과목 생성
    public Subject createSubject(CreateSubject createSubject) {
        Long currentUserId = SessionUtil.getCurrentUserIdFromSession(session);
        Subject subject = new Subject();
        subject.setUserId(currentUserId);
        subject.setSubjectName(createSubject.getSubjectName());
        subject.setGrade(createSubject.getGrade());
        subject.setImg(createSubject.getImg());

        return subjectRepository.save(subject);
    }

    // 홈 - 과목 편집
    public Subject updateSubject(Long subjectId, UpdateSubjectReq updateSubjectReq) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setSubjectName(updateSubjectReq.getSubjectName());
        subject.setImg(updateSubjectReq.getImg());
        return subjectRepository.save(subject);
    }

    // 홈 - 실패요소 선택
    public Subject updateFail(Long subjectId, CreateFailReq createFailReq) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setFail(createFailReq.getFail());

        return subjectRepository.save(subject);
    }

    // 홈 - 시험기록 추가
    public Subject updateTestRecord(Long subjectId, CreateTestRecordReq createTestRecordReq) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        subject.setDate(createTestRecordReq.getDate());
        subject.setGoalScore(createTestRecordReq.getGoalScore());
        subject.setLevel(createTestRecordReq.getLevel());
        subject.setComment(createTestRecordReq.getComment());

        // Exam 엔터티 업데이트
        List<Exam> pastExams = new ArrayList<>();
        for (ExamScoreReq examScoreReq : createTestRecordReq.getExams()) {
            Exam exam = new Exam();
            exam.setExamName(examScoreReq.getExamName());
            exam.setExamScore(examScoreReq.getExamScore());
            pastExams.add(exam);
        }
        subject.setPastExams(pastExams);

        // 캘린더에 시험 정보 추가
        Long currentUserId = SessionUtil.getCurrentUserIdFromSession(session);
        Calendar calendar = new Calendar();
        calendar.setUserId(currentUserId);
        calendar.setSubject(subject.getSubjectName());
        calendar.setDate(createTestRecordReq.getDate());
        calendarRepository.save(calendar);

        return subjectRepository.save(subject);
    }

    // 홈 - 학년 정보에 해당하는 과목 리스트 가져오기
    public List<SubjectInfoDTO> getSubjectInfo(int grade) {
        Long currentUserId = SessionUtil.getCurrentUserIdFromSession(session);
        List<Subject> subjects = subjectRepository.findByUserIdAndGrade(currentUserId, grade);
        return subjects.stream()
                .map(subject -> new SubjectInfoDTO(subject.getSubjectId(), subject.getSubjectName(), subject.getImg()))
                .collect(Collectors.toList());
    }

    // 홈 - 학년 정보와 과목을 입력받아 과목 정보 불러오기
    public SubjectDetailsDTO getSubjectDetailsById(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElse(null);

        if (subject != null) {
            SubjectDetailsDTO subjectDetailsDTO = new SubjectDetailsDTO();
            subjectDetailsDTO.setSubjectId(subject.getSubjectId());
            subjectDetailsDTO.setExams(subject.getPastExams());
            subjectDetailsDTO.setDate(subject.getDate());
            subjectDetailsDTO.setLevel(subject.getLevel());
            subjectDetailsDTO.setGoalScore(subject.getGoalScore());
            subjectDetailsDTO.setFail(subject.getFail());

            return subjectDetailsDTO;
        } else {
            return null;
        }
    }

    public SubjectInfoDTO getSubjectInfoById(Long subjectId) {
        // subjectId로 Subject 엔티티를 찾기
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with id: " + subjectId));

        // 필요한 정보만을 SubjectInfoDTO에 매핑하여 반환
        return new SubjectInfoDTO(subject.getSubjectId(), subject.getSubjectName(), subject.getImg());
    }

    public void deleteSubject(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}