package com.testmateback.domain.inquiry.respository;

import com.testmateback.domain.inquiry.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    Inquiry findByInquiryId(Long id);
}
