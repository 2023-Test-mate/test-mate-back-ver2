package com.testmateback.dTestmate.user;

import com.testmateback.dTestmate.user.dto.LoginReq;
import com.testmateback.dTestmate.user.dto.SignUpReq;
import com.testmateback.dTestmate.user.service.LoginService;
import com.testmateback.dTestmate.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class UserController {
    @RestController
    @RequiredArgsConstructor
    public static class LoginController {

        private final LoginService loginService;
        private final UserService userService;

        @PostMapping("/api/sign-up")
        public ResponseEntity<Void> login(@RequestBody SignUpReq signUpReq, HttpSession httpSession) {
            loginService.signUp(signUpReq, httpSession);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/api/login")
        public ResponseEntity<Void> login(@RequestBody LoginReq loginReq, HttpSession httpSession) {
            loginService.login(loginReq, httpSession);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/api/logout")
        public ResponseEntity<Void> logout(HttpSession httpSession) {
            loginService.logout(httpSession);
            return ResponseEntity.ok().build();
        }

        // TODO : 한국어 인코딩 설정 추가하기
        @GetMapping("api/user-check/{userId}")
        public ResponseEntity<String> checkDuplicateUserId(@PathVariable String userId) {
            boolean isDuplicate = userService.isUserIdDuplicate(userId);
            if (isDuplicate) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User with the same user ID already exists");
            } else {
                return ResponseEntity.ok("User ID is available");
            }
        }
    }

}
