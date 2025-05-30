package com.aamlid.venturebackend.service;

import com.aamlid.venturebackend.dto.AuthRequest;
import com.aamlid.venturebackend.dto.AuthResponse;
import com.aamlid.venturebackend.dto.PurchaseResponse;
import com.aamlid.venturebackend.model.User;
import com.aamlid.venturebackend.repository.UserRepository;
import com.aamlid.venturebackend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final UserRepository userRepository;

    public ResponseEntity<?> getCurrentUserInfo() {
        String userId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        String username = user.getUsername();
        String message = "Welcome " + username + ", to Venture!";

        PurchaseResponse response = PurchaseResponse.builder()
                .id(userId)
                .username(username)
                .message(message)
                .build();

        return ResponseEntity.ok(response);
    }
}
