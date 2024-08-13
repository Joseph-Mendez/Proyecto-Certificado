package com.example.library_management_system.controller.postgresql;

import com.example.library_management_system.model.mongodb.UserDocument;
import com.example.library_management_system.service.mongodb.UserDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserDocumentService userDocumentService;

    @Autowired
    public UserController(UserDocumentService userDocumentService) {
        this.userDocumentService = userDocumentService;
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<UserDocument> createUser(@RequestBody UserDocument userDocument) {
        UserDocument savedUser = userDocumentService.saveUserDocument(userDocument);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDocument> getUserById(@PathVariable String id) {
        Optional<UserDocument> user = userDocumentService.getUserDocumentById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserDocument>> getAllUsers() {
        List<UserDocument> users = userDocumentService.getAllUserDocuments();
        return ResponseEntity.ok(users);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<UserDocument> updateUser(@PathVariable String id, @RequestBody UserDocument userDocument) {
        Optional<UserDocument> updatedUser = userDocumentService.updateUserDocument(id, userDocument);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        if (userDocumentService.deleteUserDocument(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Find user by username
    @GetMapping("/search/username")
    public ResponseEntity<UserDocument> findUserByUsername(@RequestParam String username) {
        Optional<UserDocument> user = userDocumentService.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Find user by email
    @GetMapping("/search/email")
    public ResponseEntity<UserDocument> findUserByEmail(@RequestParam String email) {
        Optional<UserDocument> user = userDocumentService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Check if a username exists
    @GetMapping("/check/username")
    public ResponseEntity<Boolean> usernameExists(@RequestParam String username) {
        boolean exists = userDocumentService.usernameExists(username);
        return ResponseEntity.ok(exists);
    }

    // Check if an email exists
    @GetMapping("/check/email")
    public ResponseEntity<Boolean> emailExists(@RequestParam String email) {
        boolean exists = userDocumentService.emailExists(email);
        return ResponseEntity.ok(exists);
    }
}
