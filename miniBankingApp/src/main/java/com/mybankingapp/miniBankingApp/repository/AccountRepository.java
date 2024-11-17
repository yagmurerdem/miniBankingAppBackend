package com.mybankingapp.miniBankingApp.repository;

import com.mybankingapp.miniBankingApp.model.Account;
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
public interface AccountRepository extends JpaRepository<Account, UUID> {

    // Belirli bir kullanıcının tüm hesaplarını getir
    List<Account> findByUserId(UUID userId);

    // Hesap numarasına veya adına göre arama
    @Query("SELECT a FROM Account a WHERE a.user.id = :userId AND (a.number LIKE %:query% OR a.name LIKE %:query%)")
    List<Account> searchAccounts(@Param("userId") UUID userId, @Param("query") String query);
}