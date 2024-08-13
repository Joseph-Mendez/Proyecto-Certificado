package com.example.library_management_system.repository.postgresql;

import com.example.library_management_system.model.mongodb.LoanDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends MongoRepository<LoanDocument, String> {
    // Custom query methods can be defined here if needed

    // Find loans by user ID
    List<LoanDocument> findByUserId(String userId);

    // Find loans by book ID
    List<LoanDocument> findByBookId(String bookId);

    // Find all loans where the book has not been returned yet
    List<LoanDocument> findByReturnedFalse();
}
