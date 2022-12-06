package com.orgofarmsgroup.controller;

import com.orgofarmsgroup.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private static List<UserEntity> users = new ArrayList<>();
    static {
        users.add(
                new UserEntity(101L, "John", "john@email.com")
        );
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try{
            LOGGER.info("got a request");
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
