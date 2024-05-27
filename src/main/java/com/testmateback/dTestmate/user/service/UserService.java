package com.testmateback.dTestmate.user.service;

import com.testmateback.dTestmate.user.dto.PasswordRes;
import com.testmateback.dTestmate.user.dto.UserIdReq;
import com.testmateback.dTestmate.user.dto.UserDetailsDTO;
import com.testmateback.dTestmate.user.dto.UserIdRes;
import com.testmateback.dTestmate.user.entity.User;
import com.testmateback.dTestmate.user.repository.UserRepository;
import com.testmateback.dTestmate.util.Encryptor;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final Encryptor encryptor;
    private final UserRepository userRepository;
    private static final String LOGIN_SESSION_KEY = "USER_ID";
    private final HttpSession session;


    @Autowired
    public UserService(Encryptor encryptor, UserRepository userRepository, HttpSession session) {
        this.encryptor = encryptor;
        this.userRepository = userRepository;
        this.session = session;
    }

    @Transactional
    public User createUser(User user) {

//         이메일 중복 확인
        userRepository.findByEmail(user.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("User with the same email already exists");
                });

//         유저 아이디 중복 확인
        userRepository.findByUserId(user.getUserId())
                .ifPresent(u -> {
                    throw new DuplicateKeyException("User with the same user ID already exists");
                });


        user.setPassword(encryptor.encrypt(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> findUserByUserIdAndPassword(String userId, String password) {
        return userRepository.findByUserId(userId)
                .filter(user -> user.isMatch(encryptor, password));
    }

    public boolean isUserIdDuplicate(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    // 입력한 유저의 이름과 학년 정보 가져오기
    public UserDetailsDTO getUserDetails() {
        Long userId = getCurrentUserIdFromSession();
        return userRepository.findById(userId)
                .map(user -> new UserDetailsDTO(user.getName(), user.getGrade()))
                .orElse(null);
    }

    //사용자 이메일로 유저의 아이디 가져오기
    public UserIdRes findUserIdByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()) {
            return new UserIdRes(user.get().getUserId());
        }else {
            throw new RuntimeException("User not found");
        }
    }

//    public PasswordRes findPasswordByEmail(String email){
//        Optional<User> user = userRepository.findByEmail(email);
//        if(user.isPresent()){
//            return new PasswordRes(user.get().getPassword());
//        }else{
//            throw new RuntimeException("User not found");
//        }
//    }



    private Long getCurrentUserIdFromSession() {
        // 세션에서 사용자 ID를 가져오는 로직
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }
}
