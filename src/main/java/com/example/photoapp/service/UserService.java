package com.example.photoapp.service;

import com.example.photoapp.model.User;
import com.example.photoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }


    public List<User> getUserById(String userId) {
        return userRepository.findAllById(userId);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
