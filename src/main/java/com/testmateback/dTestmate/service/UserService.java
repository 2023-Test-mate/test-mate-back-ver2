package com.testmateback.dTestmate.service;

import com.testmateback.dTestmate.dto.CreateUser;
import com.testmateback.dTestmate.entity.Users;
import com.testmateback.dTestmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.ResourceAccessException;

import javax.security.auth.Subject;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public CreateUser.Response createUser(@Valid CreateUser.Request request) {
        Users user = Users.builder()
                .name(request.getName())
                .grade(request.getGrade())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        try {
            Users savedUser = userRepository.save(user);
            return CreateUser.Response.userResponse(savedUser);
        } catch (Exception e) {
            // 데이터베이스 예외 처리
            throw new RuntimeException("사용자 생성 중 오류가 발생했습니다.", e);
        }

    }


}
