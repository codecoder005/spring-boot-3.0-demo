package com.orgofarmsgroup.controller;

import com.orgofarmsgroup.entity.UserEntity;
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
    private static List<UserEntity> users = new ArrayList<>();
    static {
        users.add(
                new UserEntity(101L, "John", "john@email.com")
        );
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }
}
