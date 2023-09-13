package com.testmateback.dTestmate.service;

import com.testmateback.dTestmate.dto.CreateTestInfo;
import com.testmateback.dTestmate.entity.TestInfo;
import com.testmateback.dTestmate.repository.TestInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestInfoService {
    private final TestInfoRepository testInfoRepository;

    public TestInfoService(TestInfoRepository testInfoRepository) {
        this.testInfoRepository = testInfoRepository;
    }

    @Transactional
    public CreateTestInfo.Response createTestInfo(CreateTestInfo.Request request){
        TestInfo testInfo = TestInfo.builder()
                .indexes(request.getIndexes())
                .subject(request.getSubject())
                .semester(request.getSemester())
                .score(request.getScore())
                .dates(request.getDates())
                .levels(request.getLevels())
                .target(request.getTarget())
                .build();

        testInfoRepository.save(testInfo);

        return CreateTestInfo.Response.TestInfoResponse(testInfo);
    }
}