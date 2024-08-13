package com.example.library_management_system.repository.postgresql;

import com.example.library_management_system.model.mongodb.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<BookDocument, String> {
    List<BookDocument> findByAuthor(String author);
}