package com.testmateback.dTestmate.subject;


import com.testmateback.dTestmate.dao.*;
import com.testmateback.dTestmate.subject.repository.EditSubjectRepository;
import com.testmateback.dTestmate.subject.repository.HomeRepository;
import com.testmateback.dTestmate.wrongnote.WrongNote;
import com.testmateback.dTestmate.testinfo.TestInfoRepository;
import com.testmateback.dTestmate.wrongnote.repository.WrongNoteRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/home")
@RestController
public class HomeController {

    @Autowired
    private EditSubjectRepository editSubjectRepository;

    @Autowired
    private TestInfoRepository testInfoRepository;

    @Autowired
    private WrongNoteRepository wrongNoteRepository;

    @Autowired
    private HomeRepository homeRepository;

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping
    public CreateHome.Response createHome(
            @Valid @RequestBody CreateHome.Request request
    ) {
        log.info("request : {}", request);
        return homeService.createHome(request);

    }


    @GetMapping("/get-home-info")
    public HomeInfoResponse getHomeInfo(
            @RequestParam String indexes,
            @RequestParam String subject,
            @RequestParam String grade
    ) {
        HomeInfoResponse response = new HomeInfoResponse();

        // EditSubject에서 indexes와 subject에 해당하는 데이터를 가져와서 리스트로 만듭니다.
        List<EditSubject> editSubjects = editSubjectRepository.findByIndexesAndSubjectAndGrade(indexes, subject, grade);

        List<EditSubjectData> editSubjectDataList = new ArrayList<>();
        for (EditSubject editSubject : editSubjects) {
            EditSubjectData data = new EditSubjectData();
            data.setSubject(editSubject.getSubject());
            data.setPhoto(editSubject.getPhoto());
            editSubjectDataList.add(data);
        }
        response.setEditSubjectList(editSubjectDataList);

        // TestInfo에서 indexes와 subject에 해당하는 데이터를 가져와서 리스트로 만듭니다.
        List<TestInfo> testInfos = testInfoRepository.findByIndexesAndSubject(indexes, subject);

        List<TestInfoData> testInfoDataList = new ArrayList<>();
        for (TestInfo testInfo : testInfos) {
            TestInfoData data = new TestInfoData();
            data.setSubject(testInfo.getSubject());
            data.setGrade(testInfo.getGrade());
            data.setScore(testInfo.getScore());
            data.setDates(testInfo.getDates());
            data.setLevels(testInfo.getLevels());
            data.setTarget(testInfo.getTarget());
            testInfoDataList.add(data);
        }
        response.setTestInfoList(testInfoDataList);

        // WrongNote에서 indexes, grade, subject에 해당하는 데이터를 가져와서 처리합니다.
        List<WrongNote> wrongNotes = wrongNoteRepository.findByIndexesAndGradeAndSubject(indexes, grade, subject);

        List<WrongNoteData> wrongNoteDataList = new ArrayList<>();
        for (WrongNote wrongNote : wrongNotes) {
            WrongNoteData data = new WrongNoteData();
            data.setReasoncheck(wrongNote.getReasoncheck());
            data.setReason(wrongNote.getReason());
            wrongNoteDataList.add(data);
        }
        response.setWrongNoteList(wrongNoteDataList);

        // Home에서 indexes, grade, subject가 fail인 데이터를 가져와서 처리
        List<Home> homeData = homeRepository.findByIndexesAndGradeAndSubject(indexes, grade, subject);

        List<HomeData> homeDataList = new ArrayList<>();
        for (Home home : homeData) {
            HomeData data = new HomeData();
            data.setFail(home.getFail());
            homeDataList.add(data);
        }
        response.setHomeList(homeDataList);

        return response;

    }
}
