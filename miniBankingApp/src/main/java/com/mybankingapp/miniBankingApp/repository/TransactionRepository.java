package com.mybankingapp.miniBankingApp.repository;

import com.mybankingapp.miniBankingApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Belirli bir hesaba ait tüm işlemleri getir
    @Query("SELECT t FROM Transaction t WHERE t.from.id = :accountId OR t.to.id = :accountId ORDER BY t.transactionDate DESC")
    List<Transaction> findByAccountId(@Param("accountId") UUID accountId);
}