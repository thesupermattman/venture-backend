package com.aamlid.venturebackend.controller;

import com.aamlid.venturebackend.dto.AuthRequest;
import com.aamlid.venturebackend.service.AuthService;
import com.aamlid.venturebackend.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService authService;

    @GetMapping("/me")
    public ResponseEntity<?> getMe() {
        return authService.getCurrentUserInfo();
    }
}
