package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findAllByCreatedBetween(LocalDate startDate, LocalDate endDate);

    User findByEmail(String email);

    User findByUserID(Long userID);

    User findByUsername(String username);

}
