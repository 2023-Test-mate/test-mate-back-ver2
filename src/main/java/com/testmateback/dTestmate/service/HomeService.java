package com.testmateback.dTestmate.service;

import com.testmateback.dTestmate.dto.CreateHome;
import com.testmateback.dTestmate.entity.Home;
import com.testmateback.dTestmate.repository.HomeRepository;
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
                .semester(request.getSemester())
                .subject(request.getSubject())
                .build();

        homeRepository.save(home);

        return CreateHome.Response.homeResponse(home);
    }
}


