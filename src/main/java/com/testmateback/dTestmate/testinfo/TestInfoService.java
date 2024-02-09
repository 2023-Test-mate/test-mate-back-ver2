package com.testmateback.dTestmate.testinfo;

import com.testmateback.dTestmate.subject.TestInfo;
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
                .grade(request.getGrade())
                .score(request.getScore())
                .dates(request.getDates())
                .levels(request.getLevels())
                .target(request.getTarget())
                .build();

        testInfoRepository.save(testInfo);

        return CreateTestInfo.Response.TestInfoResponse(testInfo);
    }
}