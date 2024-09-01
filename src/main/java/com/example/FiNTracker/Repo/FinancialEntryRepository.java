package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.FinancialEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialEntryRepository extends JpaRepository<FinancialEntry, Long> {

    List<FinancialEntry> findAll();

}
