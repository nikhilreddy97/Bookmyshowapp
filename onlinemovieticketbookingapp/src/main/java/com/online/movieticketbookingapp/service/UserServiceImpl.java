package com.online.movieticketbookingapp.service;


import com.online.movieticketbookingapp.dto.UserDto;
import com.online.movieticketbookingapp.entity.User;
import com.online.movieticketbookingapp.exceptions.UserDetailsNotFoundException;
import com.online.movieticketbookingapp.repository.UserRepository;
import com.online.movieticketbookingapp.util.Constants;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void creatUser(User user) throws Exception {
        User userResponse = repository.save(user);
        Constants.USER_ID = userResponse.getId();
        if (userResponse == null) {
            throw new Exception("User details not saved");
        }
    }

    @Override
    public void login(UserDto user) {
        String userId = user.getUserId();
        String password = user.getPassword();
        Optional<User> userResponse = repository.findByUserIdAndPassword(userId, password);
        if (!userResponse.isPresent()) {
            throw new UserDetailsNotFoundException("Details Incorrect");
        }
    }
}


