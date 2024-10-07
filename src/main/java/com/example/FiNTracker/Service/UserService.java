package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.User;
import com.example.FiNTracker.Repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    List<User> findAll() {
        return userRepository.findAll();
    }

    List<User> findAllByCreatedBetween(LocalDate startDate, LocalDate endDate) {
        return userRepository.findAllByCreatedBetween(startDate, endDate);
    }

    User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    User findByUserId(Long userID) {
        return userRepository.findByUserId(userID);
    }

    User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
