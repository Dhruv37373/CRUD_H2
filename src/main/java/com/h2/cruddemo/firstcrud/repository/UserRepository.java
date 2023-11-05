package com.h2.cruddemo.firstcrud.repository;

import com.h2.cruddemo.firstcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
