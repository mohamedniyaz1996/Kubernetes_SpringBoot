package com.ugam.ems.service;

import com.ugam.ems.dao.UserRepository;
import com.ugam.ems.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users findUser(Users users) throws Exception {
        return userRepository.findUser(users.getUsername(), users.getPassword());
    }
}
