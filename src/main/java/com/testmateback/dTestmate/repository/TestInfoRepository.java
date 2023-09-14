package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.TestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestInfoRepository extends JpaRepository<TestInfo, Long> {
    Optional<Object> findByIndexes(String indexes);
    List<TestInfo> findAll();
}