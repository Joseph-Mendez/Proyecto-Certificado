package com.example.library_management_system.repository.mongodb;

import com.example.library_management_system.model.mongodb.BookDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDocumentRepository extends MongoRepository<BookDocument, String> {
    // Find books by author
    List<BookDocument> findByAuthor(String author);

    // Find books by title
    List<BookDocument> findByTitle(String title);

    // Find a book by its ISBN
    Optional<BookDocument> findByIsbn(String isbn);
}
