package com.example.user.service;

import com.example.user.converter.UserConverter;
import com.example.user.entity.User;
import com.example.user.model.UserModel;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }
    @Override
    public void save(UserModel userModel) {
        User newUser = userConverter.modelToEntity(userModel);
        userRepository.save(newUser);
    }
}
