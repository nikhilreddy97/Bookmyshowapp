package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.entity.Screens;
import com.online.movieticketbookingapp.repository.ScreensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ScreensServiceImpl implements ScreensService{

    @Autowired
    ScreensRepository screensRepository;
    @Override
    public void addScreens(Screens screens) throws Exception {
      Screens response = screensRepository.save(screens);
      if(response == null){
          throw new Exception("Details Not saved");
      }
    }
}
