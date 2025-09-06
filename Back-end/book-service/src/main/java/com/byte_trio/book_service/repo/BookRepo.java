package com.byte_trio.book_service.repo;

import com.byte_trio.book_service.model.Book;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@FeignClient
public interface BookRepo extends JpaRepository<Book,Long>{
    @Query("SELECT s from bookdb s WHERE s.title LIKE %:title%")
    List<Book> findAllBookByTitle(@Param("title") String title);

    @Query("SELECT s from bookdb s WHERE s.author LIKE %:author%")
    List<Book> findAllBookByAuthor(String author);

    @Query("SELECT s from bookdb s WHERE s.isbn_no LIKE %:isbn_no%")
    List<Book> findAllBookByISBN(String isbnNo);

    @Query("SELECT s from bookdb s WHERE s.genre LIKE %:genre%")
    List<Book> findAllBookByGenre(String genre);

    @Query("SELECT s FROM Bookdb s WHERE s.availability = true ")
    List<Book> findAllBookByAvailability(String availability);

    boolean existsByIsbnNo(Long isbnNo);

}
