package com.example.Tracker_logistics.service;

import com.example.Tracker_logistics.DTOS.UserDTO;
import com.example.Tracker_logistics.domain.user.User;
import com.example.Tracker_logistics.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) throws Exception {

        return this.userRepository.findById(id).orElseThrow(()-> new Exception("...."));

    }

    public User createUser(UserDTO userDTO){

        User newUser = new User(userDTO);
        this.saveUser(newUser);
        return newUser;

    }

    public void saveUser(User user){

        this.userRepository.save(user);

    }

}
