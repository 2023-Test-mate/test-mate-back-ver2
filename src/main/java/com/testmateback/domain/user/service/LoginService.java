package com.testmateback.domain.user.service;

import com.testmateback.domain.user.dao.LoginResponse;
import com.testmateback.domain.user.dto.LoginReq;
import com.testmateback.domain.user.dto.SignUpReq;
import com.testmateback.domain.user.dto.UserDetailsDTO;
import com.testmateback.domain.user.entity.User;
import com.testmateback.domain.wrongnote.DataLoader;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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


    public ResponseEntity<LoginResponse> login(@RequestBody LoginReq loginReq, HttpSession session) {
        Optional<User> user = userService.findUserByUserIdAndPassword(loginReq.getUserId(), loginReq.getPassword());
        if (user.isPresent()) {
            session.setAttribute(LOGIN_SESSION_KEY, user.get().getId());
            UserDetailsDTO userDetails = new UserDetailsDTO(user.get().getName(), user.get().getGrade());
            LoginResponse response = new LoginResponse("로그인 되었습니다.", userDetails);
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse("로그인 되지 않았습니다.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    public void logout(HttpSession session) {
        session.removeAttribute(LOGIN_SESSION_KEY);
    }
}
