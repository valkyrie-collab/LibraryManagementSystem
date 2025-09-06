package com.byte_trio.transaction_service.repository;

import com.byte_trio.transaction_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Modifying
    @Transactional
    @Query("update Transaction t set t.dueDate = :dueDate where t.id = :id")
    void updateDueDate(@Param("dueDate") Date dueDate, @Param("id") String id);

    List<Transaction> findAllByBorrowerId(String borrowerId);

//    @Modifying
//    @Transactional
//    void updateReturnDate
}
