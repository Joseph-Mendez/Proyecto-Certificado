package com.example.library_management_system.controller.mongodb;

import com.example.library_management_system.model.mongodb.LoanDocument;
import com.example.library_management_system.service.mongodb.LoanDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loan-documents")
public class LoanDocumentController {

    private final LoanDocumentService loanDocumentService;

    @Autowired
    public LoanDocumentController(LoanDocumentService loanDocumentService) {
        this.loanDocumentService = loanDocumentService;
    }

    // Create a new loan document
    @PostMapping
    public ResponseEntity<LoanDocument> createLoanDocument(@RequestBody LoanDocument loanDocument) {
        LoanDocument savedLoan = loanDocumentService.saveLoanDocument(loanDocument);
        return new ResponseEntity<>(savedLoan, HttpStatus.CREATED);
    }

    // Get a loan document by ID
    @GetMapping("/{id}")
    public ResponseEntity<LoanDocument> getLoanDocumentById(@PathVariable String id) {
        Optional<LoanDocument> loan = loanDocumentService.getLoanDocumentById(id);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all loan documents
    @GetMapping
    public ResponseEntity<List<LoanDocument>> getAllLoanDocuments() {
        List<LoanDocument> loans = loanDocumentService.getAllLoanDocuments();
        return ResponseEntity.ok(loans);
    }

    // Update an existing loan document
    @PutMapping("/{id}")
    public ResponseEntity<LoanDocument> updateLoanDocument(@PathVariable String id, @RequestBody LoanDocument loanDocument) {
        Optional<LoanDocument> updatedLoan = loanDocumentService.updateLoanDocument(id, loanDocument);
        return updatedLoan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a loan document by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanDocument(@PathVariable String id) {
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

    // Find loans by status
    @GetMapping("/search/status")
    public ResponseEntity<List<LoanDocument>> findLoansByStatus(@RequestParam String status) {
        List<LoanDocument> loans = loanDocumentService.findByBookId(status);
        return ResponseEntity.ok(loans);
    }
}
