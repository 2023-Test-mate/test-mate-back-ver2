package com.testmateback.dTestmate.user;

import com.testmateback.dTestmate.alarm.dto.AlarmDTO;
import com.testmateback.dTestmate.alarm.entity.Alarm;
import com.testmateback.dTestmate.alarm.service.AlarmService;
import com.testmateback.dTestmate.user.dto.LoginReq;
import com.testmateback.dTestmate.user.dto.SignUpReq;
import com.testmateback.dTestmate.user.dto.UserDetailsDTO;
import com.testmateback.dTestmate.user.service.LoginService;
import com.testmateback.dTestmate.user.service.UserService;
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
        public ResponseEntity<Void> login(@RequestBody SignUpReq signUpReq, HttpSession httpSession) {
            loginService.signUp(signUpReq, httpSession);
            Alarm addedAlarm = alarmService.addAlarm();
            return ResponseEntity.ok().build();
        }

        @PostMapping("/api/login")
        public ResponseEntity<String> login(@RequestBody LoginReq loginReq, HttpSession httpSession, HttpServletResponse httpServletResponse) {
            return loginService.login(loginReq, httpSession);
        }


        @PostMapping("/api/logout")
        public ResponseEntity<Void> logout(HttpSession httpSession) {
            loginService.logout(httpSession);
            return ResponseEntity.ok().build();
        }

        @GetMapping("api/user-check")
        public ResponseEntity<String> checkDuplicateUserId(@RequestParam String userId) {
            boolean isDuplicate = userService.isUserIdDuplicate(userId);
            if (isDuplicate) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User with the same user ID already exists");
            } else {
                return ResponseEntity.ok("User ID is available");
            }
        }

        @GetMapping("api/user/details")
        public UserDetailsDTO getUserDetails() {
            // 서비스를 통해 사용자 정보를 가져오기
            UserDetailsDTO userDetailsDTO = userService.getUserDetails();

            return userDetailsDTO;
        }

    }

}
