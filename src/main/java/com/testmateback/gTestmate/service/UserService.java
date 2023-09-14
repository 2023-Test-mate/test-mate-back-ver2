package com.testmateback.gTestmate.service;

import com.testmateback.dTestmate.entity.Home;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Call;
import retrofit2.http.Path;

public interface UserService {
    @GetMapping("users/{user}")
    Call<User> getPostById(@Path("user") long user);


}
//import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//
//        import java.util.List;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    // 특정 조건에 따라 사용자 데이터를 조회하는 메서드
//    public List<User> findAll();
//}
