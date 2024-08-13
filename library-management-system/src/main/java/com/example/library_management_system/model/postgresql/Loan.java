package com.example.library_management_system.model.postgresql;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @NotNull(message = "Book is mandatory")
    private Book book;

    @ManyToOne(optional = false)
    @NotNull(message = "User is mandatory")
    private User user;

    @Column(nullable = false)
    @NotNull(message = "Loan date is mandatory")
    private LocalDate loanDate;

    @Column
    private LocalDate returnDate;

    @Column(nullable = false)
    private boolean returned;

    // Constructors
    public Loan() {}

    public Loan(Book book, User user, LocalDate loanDate, LocalDate returnDate, boolean returned) {
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Loan{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }
}
