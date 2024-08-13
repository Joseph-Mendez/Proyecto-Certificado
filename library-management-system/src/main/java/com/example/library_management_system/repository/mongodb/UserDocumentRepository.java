package com.example.library_management_system.repository.mongodb;

import com.example.library_management_system.model.mongodb.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDocumentRepository extends MongoRepository<UserDocument, String> {
    // Find a user by username
    Optional<UserDocument> findByUsername(String username);

    // Find a user by email
    Optional<UserDocument> findByEmail(String email);

    // Check if a user exists by username
    boolean existsByUsername(String username);

    // Check if a user exists by email
    boolean existsByEmail(String email);
}
