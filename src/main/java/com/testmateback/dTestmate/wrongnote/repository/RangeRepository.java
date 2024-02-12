package com.testmateback.dTestmate.wrongnote.repository;

import com.testmateback.dTestmate.wrongnote.entity.Range;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RangeRepository extends JpaRepository<Range, Integer> {
    List<Range> findByUserId(Long userId);
}
