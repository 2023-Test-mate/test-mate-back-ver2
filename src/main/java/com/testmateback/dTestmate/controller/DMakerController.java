package com.testmateback.dTestmate.controller;

import com.testmateback.dTestmate.dto.CreateHome;
import com.testmateback.dTestmate.dto.CreateUser;
import com.testmateback.dTestmate.service.HomeService;
import com.testmateback.dTestmate.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final UserService userService;
    private final HomeService homeService;


    @PostMapping("/sign-up")
    public CreateUser.Response createUser(
            @Valid @RequestBody CreateUser.Request request
    ) {
        log.info("request : {}", request);
        return userService.createUser(request);

    }

//    @PostMapping("/login")
//    public LoginUser.LoginResponse login(
//            @Valid @RequestBody LoginUser.LoginRequest loginRequest
//    ) {
//        log.info("request : {}", loginRequest);
//        return userService.LoginUser(loginRequest);
//    }

    @PostMapping("/home")
    public CreateHome.Response createHome(
            @Valid @RequestBody CreateHome.Request request
    ) {
        log.info("request : {}", request);
        return homeService.createHome(request);

    }

}
