package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // Custom method to find a user by username

    List<User> findByRole(String role); // Custom method to find users by role


}
