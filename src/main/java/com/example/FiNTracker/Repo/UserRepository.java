package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
