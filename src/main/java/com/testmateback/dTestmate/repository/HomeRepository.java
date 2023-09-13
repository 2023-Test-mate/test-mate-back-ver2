package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

}