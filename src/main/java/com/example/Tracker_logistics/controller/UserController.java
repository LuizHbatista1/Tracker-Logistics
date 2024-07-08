package com.example.Tracker_logistics.controller;


import com.example.Tracker_logistics.DTOS.UserDTO;
import com.example.Tracker_logistics.domain.user.User;
import com.example.Tracker_logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody  UserDTO user){

        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser , HttpStatus.CREATED);


    }


    @GetMapping
    public ResponseEntity<?>createPing(@RequestBody User user){


        return ResponseEntity.ok("Ok");
    }



}
