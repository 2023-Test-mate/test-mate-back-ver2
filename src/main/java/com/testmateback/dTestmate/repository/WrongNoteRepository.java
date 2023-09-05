package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.TestInfo;
import com.testmateback.dTestmate.entity.WrongNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrongNoteRepository extends JpaRepository<WrongNote, Long> {

}