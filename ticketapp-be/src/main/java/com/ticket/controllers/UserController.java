package com.ticket.controllers;

import com.ticket.entities.User;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error updating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching users: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
