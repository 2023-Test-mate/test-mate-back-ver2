package com.testmateback.dTestmate.controller;

import com.testmateback.dTestmate.dto.CreateUser;
import com.testmateback.dTestmate.entity.Users;
import com.testmateback.dTestmate.repository.UserRepository;
import com.testmateback.dTestmate.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class UserController {
    // 주요 서비스 및 의존성 주입
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // 사용자 등록 요청 처리
    @PostMapping("/sign-up")
    public CreateUser.Response createUser(
            @Valid @RequestBody CreateUser.Request request
    ) {
        log.info("request : {}", request);
        return userService.createUser(request);
    }

    // 로그인 처리를 위한 컨트롤러 클래스
    @RestController
    @RequestMapping("/api")
    public class AuthController {

        @Autowired
        private UserRepository userRepository;

        // 로그인 요청 처리
        @PostMapping("/login")
        public ResponseEntity<Map<String, String>> login(@RequestBody CreateUser.Request credentials) {
            String email = credentials.getEmail();
            String password = credentials.getPassword();

            // 이메일로 사용자 찾기
            Users user = userRepository.findByEmail(email);
            if (user == null || !user.getPassword().equals(password)) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "로그인 실패");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // 로그인 성공
            Map<String, String> response = new HashMap<>();
            response.put("message", "로그인 성공");
            return ResponseEntity.ok(response);
        }
    }

}
