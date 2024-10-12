package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.AuthorizedUserId;
import com.example.FiNTracker.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAll();

    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Transaction> findAllByCategory(String category);

    List<Transaction> findAllByAmountBetween(Float amount1, Float amount2);

    List<Transaction> findAllByTransactionName(String transactionName);

    Transaction findByTransactionId(Long transactionId);

    @Query("SELECT t from Transaction t " +
            "JOIN AuthorizedUser au ON t.account = au.account " +
            "WHERE au.id = :authorizedUserId")
    List<Transaction> findAllTransactionsByAuthorizedUserId(
            @Param("authorizedUserId") AuthorizedUserId authorizedUserId
            );

    // TODO Write queries to join au.user_id to t.user_id for various purposes

    //TODO Write query to return all transactions by month
}
