package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.TestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestInfoRepository extends JpaRepository<TestInfo, Long> {

}