package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.EditSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditSubjectRepository extends JpaRepository<EditSubject, Long> {
    List<EditSubject> findAll();
}