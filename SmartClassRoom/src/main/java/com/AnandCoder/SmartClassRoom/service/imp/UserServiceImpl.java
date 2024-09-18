package com.AnandCoder.SmartClassRoom.service.imp;

import com.AnandCoder.SmartClassRoom.Model.User;
import com.AnandCoder.SmartClassRoom.repository.UserRepository;
import com.AnandCoder.SmartClassRoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Create a new user in the database
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        // Retrieve a user by their ID
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null); // Return user or null if not found
    }

    @Override
    public List<User> getAllUsers() {
        // Retrieve all users from the database
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        // Retrieve the user to be updated
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update the user's details
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setRole(userDetails.getRole());
            existingUser.setFirstName(userDetails.getFirstName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setEmail(userDetails.getEmail());
            // Save the updated user to the database
            return userRepository.save(existingUser);
        }
        return null; // Return null if user is not found
    }

    @Override
    public void deleteUser(Long id) {
        // Delete the user by their ID
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        // Find a user by their username
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        // Retrieve users by their role
        return userRepository.findByRole(role);
    }
}

