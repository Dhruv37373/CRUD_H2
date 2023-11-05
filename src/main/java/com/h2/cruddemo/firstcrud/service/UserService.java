package com.h2.cruddemo.firstcrud.service;

import com.h2.cruddemo.firstcrud.entity.User;
import java.util.*;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Integer id);
    void updateUser(Integer id,User user);
    void deleteUser(Integer id);

}
