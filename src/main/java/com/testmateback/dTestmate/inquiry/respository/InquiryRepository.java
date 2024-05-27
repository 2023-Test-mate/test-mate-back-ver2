package com.testmateback.dTestmate.inquiry.respository;

import com.testmateback.dTestmate.inquiry.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    Inquiry findByInquiryId(Long id);
}
