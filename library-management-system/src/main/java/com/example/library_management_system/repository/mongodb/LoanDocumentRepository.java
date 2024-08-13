package com.example.library_management_system.repository.mongodb;

import com.example.library_management_system.model.mongodb.LoanDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanDocumentRepository extends MongoRepository<LoanDocument, String> {
    // Find loans by user ID
    List<LoanDocument> findByUserId(String userId);

    // Find loans by book ID
    List<LoanDocument> findByBookId(String bookId);

    // Find all loans where the book has not been returned yet
    List<LoanDocument> findByReturnedFalse();

    // Find a loan by user ID and book ID
    Optional<LoanDocument> findByUserIdAndBookId(String userId, String bookId);
}
