package com.testmateback.service;

import com.testmateback.dto.CreateUser;
import com.testmateback.dto.LoginUser;
import com.testmateback.entity.Users;
import com.testmateback.exception.UserErrorCode;
import com.testmateback.exception.UserException;
import com.testmateback.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final EntityManager em;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    // body row에 입력하는 값
    @Transactional
    public CreateUser.Response CreateUser(CreateUser.Request request) {
        Users user = Users.builder()
                .name(request.getName())
                .grade(request.getGrade())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        userRepository.save(user);
        return CreateUser.Response.userResponse(user);
    }

//    public LoginUser.LoginResponse LoginUser(LoginUser.LoginRequest loginRequest) {
//        Users user = (Users) userRepository.findAll();
//        if (loginRequest.getEmail().equals(user.getEmail()) && loginRequest.getPassword().equals(user.getPassword())) {
//            return LoginUser.LoginResponse.builder().build();
//        } else {
//            throw new UserException(UserErrorCode.NO_EMAIL);
//        }
//    }

}