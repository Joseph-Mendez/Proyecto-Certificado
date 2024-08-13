package com.example.library_management_system.controller.mongodb;

import com.example.library_management_system.model.mongodb.BookDocument;
import com.example.library_management_system.service.mongodb.BookDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-documents")
public class BookDocumentController {

    private final BookDocumentService bookDocumentService;

    @Autowired
    public BookDocumentController(BookDocumentService bookDocumentService) {
        this.bookDocumentService = bookDocumentService;
    }

    // Create a new book document
    @PostMapping
    public ResponseEntity<BookDocument> createBookDocument(@RequestBody BookDocument bookDocument) {
        BookDocument savedBook = bookDocumentService.saveBookDocument(bookDocument);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Get a book document by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookDocument> getBookDocumentById(@PathVariable String id) {
        Optional<BookDocument> book = bookDocumentService.getBookDocumentById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all book documents
    @GetMapping
    public ResponseEntity<List<BookDocument>> getAllBookDocuments() {
        List<BookDocument> books = bookDocumentService.getAllBookDocuments();
        return ResponseEntity.ok(books);
    }

    // Update an existing book document
    @PutMapping("/{id}")
    public ResponseEntity<BookDocument> updateBookDocument(@PathVariable String id, @RequestBody BookDocument bookDocument) {
        Optional<BookDocument> updatedBook = bookDocumentService.updateBookDocument(id, bookDocument);
        return updatedBook.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a book document by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookDocument(@PathVariable String id) {
        if (bookDocumentService.deleteBookDocument(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Find books by title
    @GetMapping("/search/title")
    public ResponseEntity<List<BookDocument>> findBooksByTitle(@RequestParam String title) {
        List<BookDocument> books = bookDocumentService.findByTitle(title);
        return ResponseEntity.ok(books);
    }

    // Find books by author
    @GetMapping("/search/author")
    public ResponseEntity<List<BookDocument>> findBooksByAuthor(@RequestParam String author) {
        List<BookDocument> books = bookDocumentService.findByAuthor(author);
        return ResponseEntity.ok(books);
    }

    // Find a book document by ISBN
    @GetMapping("/search/isbn")
    public ResponseEntity<BookDocument> findBookByIsbn(@RequestParam String isbn) {
        Optional<BookDocument> book = bookDocumentService.findByIsbn(isbn);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
