package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email); // 이메일로 사용자 조회

}