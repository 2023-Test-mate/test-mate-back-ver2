package com.testmateback.dTestmate.service;

import com.testmateback.dTestmate.dto.CreateUser;
import com.testmateback.dTestmate.entity.Users;
import com.testmateback.dTestmate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final EntityManager em;

    // 생성자 주입을 사용하여 UserRepository를 주입
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 모든 사용자를 가져오는 메서드
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // 사용자를 생성하는 메서드
    @Transactional
    public CreateUser.Response createUser(CreateUser.Request request) {
        // CreateUser.Request로부터 Users 엔티티를 생성
        Users user = Users.builder()
                .name(request.getName())
                .grade(request.getGrade())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

        // 생성된 사용자 정보를 UserRepository를 사용하여 저장
        userRepository.save(user);

        // 저장된 사용자 정보를 CreateUser.Response로 변환하여 반환
        return CreateUser.Response.userResponse(user);
    }

    // 로그인 기능을 처리하는 메서드 (주석 처리된 부분은 사용자 로그인 구현 시 사용할 수 있음)
//    public LoginUser.LoginResponse loginUser(LoginUser.LoginRequest loginRequest) {
//        Users user = (Users) userRepository.findAll();
//        if (loginRequest.getEmail().equals(user.getEmail()) && loginRequest.getPassword().equals(user.getPassword())) {
//            return LoginUser.LoginResponse.builder().build();
//        } else {
//            throw new UserException(UserErrorCode.NO_EMAIL);
//        }
//    }
}
