package com.testmateback.dTestmate.controller;

import com.testmateback.dTestmate.dto.CreateTestInfo;
import com.testmateback.dTestmate.service.TestInfoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestInfoController {

    private final TestInfoService testInfoService;

    public TestInfoController(TestInfoService testInfoService) {
        this.testInfoService = testInfoService;
    }

    // 테스트 정보 생성 요청 처리
    @PostMapping("/test-info")
    public CreateTestInfo.Response createTestInfo(
            @Valid @RequestBody CreateTestInfo.Request request
    ) {
        log.info("request : {} ", request);
        return testInfoService.createTestInfo(request);
    }

}
