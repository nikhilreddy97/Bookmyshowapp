package com.online.movieticketbookingapp.controller;

import com.online.movieticketbookingapp.entity.Screens;
import com.online.movieticketbookingapp.service.ScreensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class ScreensController {

    @Autowired
    ScreensService service;

    @PostMapping("/add/screens")
    public ResponseEntity<String> addScreens(@RequestBody Screens screens) throws Exception{
        service.addScreens(screens);
        return ResponseEntity.status(HttpStatus.CREATED).body("Screens added successfully");
    }
}
