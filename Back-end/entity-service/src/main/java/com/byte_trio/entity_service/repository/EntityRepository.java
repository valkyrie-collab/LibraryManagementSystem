package com.byte_trio.entity_service.repository;

import com.byte_trio.entity_service.model.EntityField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends JpaRepository<EntityField, String> {

//    @Modifying
//    @Query("update EntityField e set e.borrowedBook = :bookId where e.id = :id")
//    void updateBookBorrow(@Param("bookId") String bookId, @Param("id") String id);
//
//    @Query("select e.borrowedBook from EntityField e where e.id = :id")
//    String getBookId(@Param("id") String id);

}
