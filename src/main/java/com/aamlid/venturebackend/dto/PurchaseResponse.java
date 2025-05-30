package com.aamlid.venturebackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseResponse {
    private String id;
    private String username;
    private String message;
}