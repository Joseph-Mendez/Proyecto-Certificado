package com.example.library_management_system.service.postgresql;

import com.example.library_management_system.model.mongodb.LoanDocument;
import com.example.library_management_system.repository.mongodb.LoanDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanDocumentRepository loanRepository;

    @Autowired
    public LoanService(LoanDocumentRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // Save a new loan or update an existing loan
    public LoanDocument saveLoan(LoanDocument loanDocument) {
        return loanRepository.save(loanDocument);
    }

    // Get a loan by ID
    public Optional<LoanDocument> getLoanById(String id) {
        return loanRepository.findById(id);
    }

    // Get all loans
    public List<LoanDocument> getAllLoans() {
        return loanRepository.findAll();
    }

    // Update an existing loan
    public Optional<LoanDocument> updateLoan(String id, LoanDocument loanDocument) {
        if (loanRepository.existsById(id)) {
            loanDocument.setId(id); // Ensure the ID is set for update
            return Optional.of(loanRepository.save(loanDocument));
        } else {
            return Optional.empty();
        }
    }

    // Delete a loan by ID
    public boolean deleteLoan(String id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Find loans by user ID
    public List<LoanDocument> findByUserId(String userId) {
        return loanRepository.findByUserId(userId);
    }

    // Find loans by book ID
    public List<LoanDocument> findByBookId(String bookId) {
        return loanRepository.findByBookId(bookId);
    }

    // Find all loans where the book has not been returned yet
    public List<LoanDocument> findNotReturnedLoans() {
        return loanRepository.findByReturnedFalse();
    }

    // Find a loan by user ID and book ID
    public Optional<LoanDocument> findByUserIdAndBookId(String userId, String bookId) {
        return loanRepository.findByUserIdAndBookId(userId, bookId);
    }
}
