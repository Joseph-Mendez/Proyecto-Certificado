package com.example.library_management_system.model.mongodb;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "books")
public class BookDocument {

    @Id
    private String id;

    private String isbn;

    private String title;

    private String author;

    private LocalDate publishedDate;

    private boolean available;

    // Constructors
    public BookDocument() {}

    public BookDocument(String isbn, String title, String author, LocalDate publishedDate, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.available = available;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "BookDocument{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + publishedDate +
                ", available=" + available +
                '}';
    }
}