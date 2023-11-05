package com.h2.cruddemo.firstcrud.controller;

import com.h2.cruddemo.firstcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.h2.cruddemo.firstcrud.entity.User;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService abc){
        userService = abc;
    }

    @GetMapping("/User")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> tempUserList = userService.getAllUsers();
        return new ResponseEntity<>(tempUserList, HttpStatus.OK);
    }

    @GetMapping("/User/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @PostMapping("/User")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.OK);
    }

    @PutMapping("/User/{id}")
    public ResponseEntity<User> updateCurrentUser(@PathVariable("id") Integer id, @RequestBody User user){
        userService.updateUser(id,user);
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @DeleteMapping("/User/{id}")
    public HttpStatus deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return HttpStatus.OK;
    }

}
