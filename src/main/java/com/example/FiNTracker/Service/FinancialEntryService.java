package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.FinancialEntry;
import com.example.FiNTracker.Repo.FinancialEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinancialEntryService {

    private final FinancialEntryRepository financialEntryRepository;

    @Autowired
    public FinancialEntryService(FinancialEntryRepository financialEntryRepository) {
        this.financialEntryRepository = financialEntryRepository;
    }

    public List<FinancialEntry> findAllFinancialEntries() {
        return financialEntryRepository.findAll();
    }


}
