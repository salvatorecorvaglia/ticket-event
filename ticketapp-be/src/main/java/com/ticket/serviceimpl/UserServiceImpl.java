package com.ticket.serviceimpl;

import com.ticket.entities.User;
import com.ticket.repositories.UserRepository;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error saving user", e);
        }
    }

    @Override
    public User updateUser(Long id, User user) {
        try {
            User existingUser = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return userRepository.save(existingUser);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting user", e);
        }
    }

    @Override
    public User getUserById(Long id) {
        try {
            return userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        } catch (Exception e) {
            throw new RuntimeException("Error fetching user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching users", e);
        }
    }
}
