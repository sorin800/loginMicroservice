package com.example.login.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

        public String findByName(String name);

        public String findByLastName(String name);
}
