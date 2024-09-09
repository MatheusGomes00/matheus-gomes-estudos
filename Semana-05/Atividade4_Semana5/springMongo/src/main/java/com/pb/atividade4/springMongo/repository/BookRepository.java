package com.pb.atividade4.springMongo.repository;

import com.pb.atividade4.springMongo.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    @Query("{ 'author': { $regex: ?0, $options: 'i' } }")
    List<Book> searchAuthor(String text);

    Book findByTitleContainingIgnoreCase(String tile);

    void deleteByTitleContainingIgnoreCase(String title);

    @Query("{ 'pubYear': { $regex: ?0, $options: 'i' } }")
    List<Book> searchPubYear(String text);
}
