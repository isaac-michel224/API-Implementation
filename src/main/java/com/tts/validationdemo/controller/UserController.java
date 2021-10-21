package com.tts.validationdemo.controller;

import com.tts.validationdemo.model.User;
import com.tts.validationdemo.repository.EndUserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    EndUserRepository userRepository;

    @GetMapping("/test")
    ResponseEntity<User> testUser() {
                return new ResponseEntity<>(new User("test", "test@gmail.com"),
                HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid User user,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
