package com.example.FiNTracker.Controller;

import com.example.FiNTracker.Entity.FinancialEntry;
import com.example.FiNTracker.Service.FinancialEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinancialEntryController {

    private final FinancialEntryService financialEntryService;

    @Autowired
    public FinancialEntryController(FinancialEntryService financialEntryService) {
        this.financialEntryService = financialEntryService;
    }

    @GetMapping("/get")
    public List<FinancialEntry> getAllFinancialEntries() {
        return financialEntryService.findAllFinancialEntries();
    }
}
