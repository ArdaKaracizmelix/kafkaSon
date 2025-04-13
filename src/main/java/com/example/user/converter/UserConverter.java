package com.example.user.converter;

import com.example.user.entity.User;
import com.example.user.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserModel entityToModel(UserModel user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setLastName(user.getLastName());
        userModel.setPhoneNumber(user.getPhoneNumber());
        return userModel;
    }
    public User modelToEntity(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setLastName(userModel.getLastName());
        user.setPhoneNumber(userModel.getPhoneNumber());
        return user;
    }
 }
