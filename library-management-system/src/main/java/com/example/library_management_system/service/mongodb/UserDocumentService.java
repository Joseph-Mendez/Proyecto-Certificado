package com.example.library_management_system.service.mongodb;

import com.example.library_management_system.model.mongodb.UserDocument;
import com.example.library_management_system.repository.mongodb.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDocumentService {

    private final UserDocumentRepository userDocumentRepository;

    @Autowired
    public UserDocumentService(UserDocumentRepository userDocumentRepository) {
        this.userDocumentRepository = userDocumentRepository;
    }

    // Save a new user document or update an existing one
    public UserDocument saveUserDocument(UserDocument userDocument) {
        return userDocumentRepository.save(userDocument);
    }

    // Get a user document by ID
    public Optional<UserDocument> getUserDocumentById(String id) {
        return userDocumentRepository.findById(id);
    }

    // Get all user documents
    public List<UserDocument> getAllUserDocuments() {
        return userDocumentRepository.findAll();
    }

    // Update an existing user document
    public Optional<UserDocument> updateUserDocument(String id, UserDocument userDocument) {
        if (userDocumentRepository.existsById(id)) {
            userDocument.setId(id); // Ensure the ID is set for update
            return Optional.of(userDocumentRepository.save(userDocument));
        } else {
            return Optional.empty();
        }
    }

    // Delete a user document by ID
    public boolean deleteUserDocument(String id) {
        if (userDocumentRepository.existsById(id)) {
            userDocumentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Find user documents by username
    public Optional<UserDocument> findByUsername(String username) {
        return userDocumentRepository.findByUsername(username);
    }

    // Find user documents by email
    public Optional<UserDocument> findByEmail(String email) {
        return userDocumentRepository.findByEmail(email);
    }

    // Check if a username exists
    public boolean usernameExists(String username) {
        return userDocumentRepository.existsByUsername(username);
    }

    // Check if an email exists
    public boolean emailExists(String email) {
        return userDocumentRepository.existsByEmail(email);
    }
}
