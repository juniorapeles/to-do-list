package com.junior.taskapp.dto;

public record LoginResponse(String accessToken, long expiresIn) {
}