package com.example.library_management_system.service.postgresql;

import com.example.library_management_system.model.mongodb.UserDocument;
import com.example.library_management_system.repository.mongodb.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserDocumentRepository userRepository;

    @Autowired
    public UserService(UserDocumentRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save a new user or update an existing user
    public UserDocument saveUser(UserDocument userDocument) {
        return userRepository.save(userDocument);
    }

    // Get a user by ID
    public Optional<UserDocument> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<UserDocument> getAllUsers() {
        return userRepository.findAll();
    }

    // Update an existing user
    public Optional<UserDocument> updateUser(String id, UserDocument userDocument) {
        if (userRepository.existsById(id)) {
            userDocument.setId(id); // Ensure the ID is set for update
            return Optional.of(userRepository.save(userDocument));
        } else {
            return Optional.empty();
        }
    }

    // Delete a user by ID
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    // Find a user by username
    public Optional<UserDocument> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Find a user by email
    public Optional<UserDocument> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Check if a username exists
    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    // Check if an email exists
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
