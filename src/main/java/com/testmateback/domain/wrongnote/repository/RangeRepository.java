package com.testmateback.domain.wrongnote.repository;

import com.testmateback.domain.wrongnote.entity.Range;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RangeRepository extends JpaRepository<Range, Integer> {
    List<Range> findByUserId(Long userId);
}
