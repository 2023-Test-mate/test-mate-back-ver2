package com.testmateback.dTestmate.wrongnote.repository;

import com.testmateback.dTestmate.wrongnote.entity.Reason;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReasonRepository extends JpaRepository<Reason, Integer> {
    List<Reason> findByUserId(Long userId);
}
