package com.example.FiNTracker.Controller;

import com.example.FiNTracker.Entity.FinancialEntry;
import com.example.FiNTracker.Service.FinancialEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

    @GetMapping("/date-range")
    public List<FinancialEntry> getAllFinancialEntriesBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return financialEntryService.findAllFinancialEntriesBetweenDates(startDate, endDate);
    }

    @GetMapping("category")
    public List<FinancialEntry> getAllEntriesByCategory(
            @RequestParam String category
    ) {
        return financialEntryService.findAllEntiresByCategory(category);
    }
}
