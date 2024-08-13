package com.example.library_management_system.repository.postgresql;

import com.example.library_management_system.model.mongodb.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {
    // Custom query methods can be defined here if needed

    // Find user by username
    Optional<UserDocument> findByUsername(String username);

    // Find user by email
    Optional<UserDocument> findByEmail(String email);
}
