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
    @Query("SELECT s from Book s WHERE LOWER(s.title) LIKE %:title%")
    List<Book> findAllBookByTitle(@Param("title") String title);

    @Query("SELECT s from Book s WHERE LOWER(s.author) LIKE %:author%")
    List<Book> findAllBookByAuthor(String author);

    @Query("SELECT s from Book s WHERE CAST(s.isbn_no AS string) LIKE %:isbn_no%")
    List<Book> findAllBookByISBN(@Param("isbn_no") long isbn_no);

    @Query("SELECT s from Book s WHERE LOWER(s.genre) LIKE %:genre%")
    List<Book> findAllBookByGenre(String genre);

//    @Query("SELECT s FROM Book s WHERE s.availabilty = true ")
//    List<Book> findAllBookByAvailability(String availability);

}
