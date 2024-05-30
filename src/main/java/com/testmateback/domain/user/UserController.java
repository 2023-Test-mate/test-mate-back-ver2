package com.testmateback.domain.user;

import com.testmateback.domain.alarm.entity.Alarm;
import com.testmateback.domain.alarm.service.AlarmService;
import com.testmateback.domain.user.dto.*;
import com.testmateback.domain.user.service.LoginService;
import com.testmateback.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
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
        private final AlarmService alarmService;


        @PostMapping("/api/sign-up")
        public ResponseEntity<String> login(@RequestBody SignUpReq signUpReq, HttpSession httpSession) {
            try {
                loginService.signUp(signUpReq, httpSession);
                Alarm addedAlarm = alarmService.addAlarm();
                return ResponseEntity.ok("{\"message\": \"Successfully signed up.\"}");
            } catch (Exception e) {
                log.error("Error during user sign-up", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Failed to sign up.\"}");
            }
        }

        @PostMapping("/api/login")
        public ResponseEntity<String> login(@RequestBody LoginReq loginReq, HttpSession httpSession, HttpServletResponse httpServletResponse) {
            return loginService.login(loginReq, httpSession);
        }


        @PostMapping("/api/logout")
        public ResponseEntity<String> logout(HttpSession httpSession) {
            loginService.logout(httpSession);
            return ResponseEntity.ok("{\"message\": \"Successfully logged out.\"}");
        }

        @GetMapping("api/user-check")
        public ResponseEntity<String> checkDuplicateUserId(@RequestParam String userId) {
            boolean isDuplicate = userService.isUserIdDuplicate(userId);
            if (isDuplicate) {
                return ResponseEntity.ok("{\"message\": \"User with the same user ID already exists\"}");
            } else {
                return ResponseEntity.ok("{\"message\": \"User ID is available\"}");
            }
        }

        @GetMapping("api/find-id")
        public ResponseEntity<UserIdRes> findUserId(@RequestBody UserIdReq userIdReq) {
            UserIdRes userIdRes = userService.findUserIdByEmail(userIdReq.getEmail());

            return ResponseEntity.ok(userIdRes);
        }

//        @GetMapping("api/find-password")
//        public ResponseEntity<PasswordRes> findPassword(@RequestBody UserIdReq userIdReq) {
//            PasswordRes passwordRes = userService.findPasswordByEmail(userIdReq.getEmail());
//            return ResponseEntity.ok(passwordRes);
//        }

        @GetMapping("api/user/details")
        public UserDetailsDTO getUserDetails() {
            // 서비스를 통해 사용자 정보를 가져오기
            UserDetailsDTO userDetailsDTO = userService.getUserDetails();

            return userDetailsDTO;
        }

    }

}
