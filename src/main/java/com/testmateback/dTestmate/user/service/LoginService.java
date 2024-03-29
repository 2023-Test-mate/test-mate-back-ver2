package com.testmateback.dTestmate.user.service;

import com.testmateback.dTestmate.user.dto.LoginReq;
import com.testmateback.dTestmate.user.dto.SignUpReq;
import com.testmateback.dTestmate.user.entity.User;
import com.testmateback.dTestmate.wrongnote.DataLoader;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final static String LOGIN_SESSION_KEY = "USER_ID";
    private final UserService userService;
    @Autowired
    private DataLoader dataLoader;
    @Transactional
    public void signUp(SignUpReq signUpReq, HttpSession session) {
        try {
            User user = new User(
                    signUpReq.getUserId(),
                    signUpReq.getName(),
                    signUpReq.getEmail(),
                    signUpReq.getGrade(),
                    signUpReq.getPassword()
            );
            userService.createUser(user);
            dataLoader.DataInit(user.getId());
            session.setAttribute(LOGIN_SESSION_KEY, user.getId());
        } catch (Exception e) {
            log.error("Error during user sign-up", e);
            throw new RuntimeException("Error during user sign-up", e);
        }
    }


    public ResponseEntity<String> login(LoginReq loginReq, HttpSession session) {
        Long userId = (Long) session.getAttribute(LOGIN_SESSION_KEY);
        Optional<User> user = userService.findUserByUserIdAndPassword(loginReq.getUserId(), loginReq.getPassword());
        if (user.isPresent()) {
            session.setAttribute(LOGIN_SESSION_KEY, user.get().getId());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 되지 않았습니다.");
        }
    }

    public void logout(HttpSession session) {
        session.removeAttribute(LOGIN_SESSION_KEY);
    }
}
