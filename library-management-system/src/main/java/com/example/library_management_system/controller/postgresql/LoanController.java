package com.example.library_management_system.controller.postgresql;

import com.example.library_management_system.model.mongodb.LoanDocument;
import com.example.library_management_system.service.mongodb.LoanDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanDocumentService loanDocumentService;

    @Autowired
    public LoanController(LoanDocumentService loanDocumentService) {
        this.loanDocumentService = loanDocumentService;
    }

    // Create a new loan
    @PostMapping
    public ResponseEntity<LoanDocument> createLoan(@RequestBody LoanDocument loanDocument) {
        LoanDocument savedLoan = loanDocumentService.saveLoanDocument(loanDocument);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    // Get a loan by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanDocument> getLoanById(@PathVariable String id) {
        Optional<LoanDocument> loan = loanDocumentService.getLoanDocumentById(id);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all loans
    @GetMapping
    public ResponseEntity<List<LoanDocument>> getAllLoans() {
        List<LoanDocument> loans = loanDocumentService.getAllLoanDocuments();
        return ResponseEntity.ok(loans);
    }

    // Update an existing loan
    @PutMapping("/{id}")
    public ResponseEntity<LoanDocument> updateLoan(@PathVariable String id, @RequestBody LoanDocument loanDocument) {
        Optional<LoanDocument> updatedLoan = loanDocumentService.updateLoanDocument(id, loanDocument);
        return updatedLoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a loan by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable String id) {
        if (loanDocumentService.deleteLoanDocument(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Find loans by user ID
    @GetMapping("/search/user")
    public ResponseEntity<List<LoanDocument>> findLoansByUserId(@RequestParam String userId) {
        List<LoanDocument> loans = loanDocumentService.findByUserId(userId);
        return ResponseEntity.ok(loans);
    }

    // Find loans by book ID
    @GetMapping("/search/book")
    public ResponseEntity<List<LoanDocument>> findLoansByBookId(@RequestParam String bookId) {
        List<LoanDocument> loans = loanDocumentService.findByBookId(bookId);
        return ResponseEntity.ok(loans);
    }

    // Find all loans where the book has not been returned yet
    @GetMapping("/search/not-returned")
    public ResponseEntity<List<LoanDocument>> findNotReturnedLoans() {
        List<LoanDocument> loans = loanDocumentService.findNotReturnedLoans();
        return ResponseEntity.ok(loans);
    }

    // Find a loan by user ID and book ID
    @GetMapping("/search/user-book")
    public ResponseEntity<LoanDocument> findLoanByUserIdAndBookId(@RequestParam String userId, @RequestParam String bookId) {
        Optional<LoanDocument> loan = loanDocumentService.findByUserIdAndBookId(userId, bookId);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
