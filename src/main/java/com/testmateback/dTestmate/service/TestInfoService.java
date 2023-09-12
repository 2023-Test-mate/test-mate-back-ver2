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
                .test_subject(request.getTest_subject())
                .test_semester(request.getTest_semester())
                .test_score(request.getTest_score())
                .test_date(request.getTest_date())
                .test_level(request.getTest_level())
                .test_target(request.getTest_target())
                .build();

        testInfoRepository.save(testInfo);

        return CreateTestInfo.Response.TestInfoResponse(testInfo);
    }
}