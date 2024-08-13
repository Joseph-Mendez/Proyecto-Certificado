package com.example.library_management_system.service.mongodb;

import com.example.library_management_system.model.mongodb.BookDocument;
import com.example.library_management_system.repository.mongodb.BookDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookDocumentService {

    private final BookDocumentRepository bookDocumentRepository;

    @Autowired
    public BookDocumentService(BookDocumentRepository bookDocumentRepository) {
        this.bookDocumentRepository = bookDocumentRepository;
    }

    // Save a new book document or update an existing one
    public BookDocument saveBookDocument(BookDocument bookDocument) {
        return bookDocumentRepository.save(bookDocument);
    }

    // Get a book document by ID
    public Optional<BookDocument> getBookDocumentById(String id) {
        return bookDocumentRepository.findById(id);
    }

    // Get all book documents
    public List<BookDocument> getAllBookDocuments() {
        return bookDocumentRepository.findAll();
    }

    // Update an existing book document
    public Optional<BookDocument> updateBookDocument(String id, BookDocument bookDocument) {
        if (bookDocumentRepository.existsById(id)) {
            bookDocument.setId(id); // Ensure the ID is set for update
            return Optional.of(bookDocumentRepository.save(bookDocument));
        } else {
            return Optional.empty();
        }
    }

    // Delete a book document by ID
    public boolean deleteBookDocument(String id) {
        if (bookDocumentRepository.existsById(id)) {
            bookDocumentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Find book documents by title
    public List<BookDocument> findByTitle(String title) {
        return bookDocumentRepository.findByTitle(title);
    }

    // Find book documents by author
    public List<BookDocument> findByAuthor(String author) {
        return bookDocumentRepository.findByAuthor(author);
    }

    // Find book documents by ISBN
    public Optional<BookDocument> findByIsbn(String isbn) {
        return bookDocumentRepository.findByIsbn(isbn);
    }
}
