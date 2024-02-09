package com.testmateback.dTestmate.testinfo;

import com.testmateback.dTestmate.subject.TestInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestInfoRepository extends JpaRepository<TestInfo, Long> {
    List<TestInfo> findByIndexes(String indexes);

    List<TestInfo> findByIndexesAndSubject(String indexes, String subject);
}