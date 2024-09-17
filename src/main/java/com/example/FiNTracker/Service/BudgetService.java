package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.Budget;
import com.example.FiNTracker.Repo.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public List<Budget> findAllByUserId(Long userID) {
        return budgetRepository.findAllByUserId(userID);
    }

}
