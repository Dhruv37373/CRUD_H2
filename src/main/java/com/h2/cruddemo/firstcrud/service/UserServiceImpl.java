package com.h2.cruddemo.firstcrud.service;

import com.h2.cruddemo.firstcrud.entity.User;
import com.h2.cruddemo.firstcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository ur){
        userRepository = ur;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> itr = userRepository.findAll();
        for(User user1 : itr){
            users.add(user1);
        }
        return users;
    }

    @Override
    public User getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        else{
            System.out.println("User not found");
             return null;
        }
    }

    @Override
    public void updateUser(Integer id, User user) {
        Optional<User> tempUser = userRepository.findById(id);
        if(tempUser.isPresent()){
            User temporaryUser = tempUser.get();
            temporaryUser.setUserName(user.getUserName());
            temporaryUser.setPasswd(user.getPasswd());
            userRepository.save(temporaryUser);
            //return temporaryUser;
        }
        else{
            System.out.println("User that you are trying to update is not present");
            //return null;
        }

    }

    @Override
    public void deleteUser(Integer id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            userRepository.delete(user.get());
        } else{
            System.out.println("User not found");
        }
    }
}
