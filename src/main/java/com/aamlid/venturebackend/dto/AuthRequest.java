package com.aamlid.venturebackend.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String email; // Optional for login
    private String password;
}