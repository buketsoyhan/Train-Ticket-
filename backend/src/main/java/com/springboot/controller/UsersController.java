package com.springboot.controller;

import com.springboot.repository.UsersRepository;

import java.util.List;

import com.springboot.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getUsers(){
        List<Users> users = usersRepository.findAll();
        return new ResponseEntity<> (users, HttpStatus.OK);
    }
}
