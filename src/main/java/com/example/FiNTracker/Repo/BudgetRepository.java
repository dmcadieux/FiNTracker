package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

    List<Budget> findAll();

    List<Budget> findAllByUserId(Long userId);


}
