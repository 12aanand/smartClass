package com.AnandCoder.SmartClassRoom.service;

import com.AnandCoder.SmartClassRoom.Model.User;

import java.util.List;

public interface UserService {
    User createUser(User user); // Create a new user

    User getUserById(Long id); // Retrieve a user by ID

    List<User> getAllUsers(); // Retrieve all users

    User updateUser(Long id, User user); // Update an existing user

    void deleteUser(Long id); // Delete a user by ID

    User findByUsername(String username); // Find a user by username

    List<User> getUsersByRole(String role); // Retrieve users by role (STUDENT, TEACHER, ADMIN)

}
