TestInfoService

        package com.testmateback.gTestmate.service;

import com.testmateback.dTestmate.entity.Home;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.Path;

public interface WrongNoteService {
    @GetMapping("wrongs/{wrong}")
    Call<TestInfo> getPostById(@Path("wrong") long wrong);


}
