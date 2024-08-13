package com.example.library_management_system.service.postgresql;

import com.example.library_management_system.model.mongodb.BookDocument;
import com.example.library_management_system.repository.mongodb.BookDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookDocumentRepository bookRepository;

    @Autowired
    public BookService(BookDocumentRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Save a new book or update an existing book
    public BookDocument saveBook(BookDocument bookDocument) {
        return bookRepository.save(bookDocument);
    }

    // Get a book by ID
    public Optional<BookDocument> getBookById(String id) {
        return bookRepository.findById(id);
    }

    // Get all books
    public List<BookDocument> getAllBooks() {
        return bookRepository.findAll();
    }

    // Update an existing book
    public Optional<BookDocument> updateBook(String id, BookDocument bookDocument) {
        if (bookRepository.existsById(id)) {
            bookDocument.setId(id); // Ensure the ID is set for update
            return Optional.of(bookRepository.save(bookDocument));
        } else {
            return Optional.empty();
        }
    }

    // Delete a book by ID
    public boolean deleteBook(String id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}