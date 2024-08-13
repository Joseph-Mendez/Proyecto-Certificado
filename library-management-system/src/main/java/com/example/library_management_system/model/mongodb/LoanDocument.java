package com.example.library_management_system.model.mongodb;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "loans")
public class LoanDocument {

    @Id
    private String id;

    @NotNull(message = "Book ID is mandatory")
    private String bookId;

    @NotNull(message = "User ID is mandatory")
    private String userId;

    @NotNull(message = "Loan date is mandatory")
    private LocalDate loanDate;

    private LocalDate returnDate;

    private boolean returned;

    // Constructors
    public LoanDocument() {}

    public LoanDocument(String bookId, String userId, LocalDate loanDate, LocalDate returnDate, boolean returned) {
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "LoanDocument{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", userId='" + userId + '\'' +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }
}
