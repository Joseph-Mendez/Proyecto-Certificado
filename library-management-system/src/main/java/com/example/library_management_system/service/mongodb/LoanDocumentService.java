package com.example.library_management_system.service.mongodb;

import com.example.library_management_system.model.mongodb.LoanDocument;
import com.example.library_management_system.repository.mongodb.LoanDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanDocumentService {

    private final LoanDocumentRepository loanDocumentRepository;

    @Autowired
    public LoanDocumentService(LoanDocumentRepository loanDocumentRepository) {
        this.loanDocumentRepository = loanDocumentRepository;
    }

    // Save a new loan document or update an existing one
    public LoanDocument saveLoanDocument(LoanDocument loanDocument) {
        return loanDocumentRepository.save(loanDocument);
    }

    // Get a loan document by ID
    public Optional<LoanDocument> getLoanDocumentById(String id) {
        return loanDocumentRepository.findById(id);
    }

    // Get all loan documents
    public List<LoanDocument> getAllLoanDocuments() {
        return loanDocumentRepository.findAll();
    }

    // Update an existing loan document
    public Optional<LoanDocument> updateLoanDocument(String id, LoanDocument loanDocument) {
        if (loanDocumentRepository.existsById(id)) {
            loanDocument.setId(id); // Ensure the ID is set for update
            return Optional.of(loanDocumentRepository.save(loanDocument));
        } else {
            return Optional.empty();
        }
    }

    // Delete a loan document by ID
    public boolean deleteLoanDocument(String id) {
        if (loanDocumentRepository.existsById(id)) {
            loanDocumentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Find loan documents by user ID
    public List<LoanDocument> findByUserId(String userId) {
        return loanDocumentRepository.findByUserId(userId);
    }

    // Find loan documents by book ID
    public List<LoanDocument> findByBookId(String bookId) {
        return loanDocumentRepository.findByBookId(bookId);
    }

    // Find all loan documents where the book has not been returned yet
    public List<LoanDocument> findNotReturnedLoans() {
        return loanDocumentRepository.findByReturnedFalse();
    }

    // Find a loan document by user ID and book ID
    public Optional<LoanDocument> findByUserIdAndBookId(String userId, String bookId) {
        return loanDocumentRepository.findByUserIdAndBookId(userId, bookId);
    }
}
