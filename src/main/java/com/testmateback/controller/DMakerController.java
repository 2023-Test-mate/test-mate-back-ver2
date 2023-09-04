package com.testmateback.controller;

import com.testmateback.dto.CreateUser;
import com.testmateback.dto.LoginUser;
import com.testmateback.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final UserService userService;


    @PostMapping("/sign-up")
    public CreateUser.Response createUser(
            @Valid @RequestBody CreateUser.Request request
    ) {
        log.info("request : {}", request);
        return userService.CreateUser(request);

    }

//    @PostMapping("/login")
//    public LoginUser.LoginResponse login(
//            @Valid @RequestBody LoginUser.LoginRequest loginRequest
//    ) {
//        log.info("request : {}", loginRequest);
//        return userService.LoginUser(loginRequest);
//    }

}
