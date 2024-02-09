package com.testmateback.dTestmate.subject;

import com.testmateback.dTestmate.subject.repository.HomeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HomeService {
    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Transactional
    public CreateHome.Response createHome(CreateHome.Request request){
        Home home = Home.builder()
                .indexes(request.getIndexes())
                .fail(request.getFail())
                .grade(request.getGrade())
                .subject(request.getSubject())
                .build();

        homeRepository.save(home);

        return CreateHome.Response.homeResponse(home);
    }
}


