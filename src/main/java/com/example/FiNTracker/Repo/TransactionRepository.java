package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAll();

    List<Transaction> findByDateBetweenAndAccountId(LocalDate startDate, LocalDate endDate, Long accountId);

    List<Transaction> findAllByCategory(String category);

    List<Transaction> findAllByAmountBetween(Float amount1, Float amount2);

    List<Transaction> findAllByTransactionName(String transactionName);

    Transaction findByTransactionId(Long transactionId);

    // Returns all transactions for all accounts that the user has access to
    @Query("SELECT DISTINCT t FROM Transaction t " +
            "JOIN AuthorizedUser au ON t.accountId = au.id.accountId " +
            "WHERE au.id.userId = :userId")
    List<Transaction> findDistinctTransactionByUserId(@Param("userId") Long userId);

    // Finds all transactions for a particular account
    @Query("SELECT DISTINCT t FROM Transaction t " +
            "JOIN AuthorizedUser au ON t.accountId = au.id.accountId " +
            "WHERE au.id.accountId = :accountId")
    List<Transaction> findDistinctTransactionByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t.category, SUM(t.amount) " +
            "FROM Transaction t " +
            "WHERE t.category = :category AND t.accountId = :accountId " +
            "GROUP BY t.category")
    List<Object[]> sumAmountByCategory(@Param("category") String category, @Param("accountId") Long accountId);



    // TODO Fix date so it doesn't return null
}
