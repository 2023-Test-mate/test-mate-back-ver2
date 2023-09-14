TestInfoService

        package com.testmateback.gTestmate.service;

import com.testmateback.dTestmate.entity.Home;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.Path;

public interface CalendarService {
    @GetMapping("Calendars/{Calendar}")
    Call<TestInfo> getPostById(@Path("Calendar") long Calendar);


}
