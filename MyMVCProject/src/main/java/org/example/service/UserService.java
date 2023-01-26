package org.example.service;

import lombok.NoArgsConstructor;
import org.example.dao.UserDao;
import org.example.dto.UserLoginRequest;
import org.example.dto.UserRegisterRequest;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@NoArgsConstructor
@Repository
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(final UserRegisterRequest userRegisterRequest) {

        User user = User.builder()
                .name(userRegisterRequest.getName())
                .username(userRegisterRequest.getUsername())
                .password(userRegisterRequest.getPassword())
                .phoneNumber(userRegisterRequest.getPhoneNumber())
                .photo_url(userRegisterRequest.getPhoto_url())
                .build();
        return userDao.add(user);
    }

    public User login(final UserLoginRequest userLoginRequest) {
        return userDao.login(userLoginRequest);
    }





}
