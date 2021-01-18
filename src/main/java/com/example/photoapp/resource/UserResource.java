package com.example.photoapp.resource;

import com.example.photoapp.exceptions.InvalidTokenException;
import com.example.photoapp.model.FirebaseUser;
import com.example.photoapp.model.User;
import com.example.photoapp.service.FirebaseService;
import com.example.photoapp.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }



    @GetMapping("/find")
    public List<User> getUserById(@RequestParam(name = "userId") String userId){
        return userService.getUserById(userId);
    }

    @PutMapping
    public User updateUser(@RequestBody User user, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            return userService.updateUser(user);
        }
        return null;
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name = "userId") String userId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException, InvalidTokenException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser != null){
            userService.deleteUser(userId);
        }
    }



}
