package com.online.movieticketbookingapp.service;

import com.online.movieticketbookingapp.dto.UserDto;
import com.online.movieticketbookingapp.entity.User;

public interface UserService {
    void creatUser(User user) throws Exception;

    void login(UserDto user);
}
