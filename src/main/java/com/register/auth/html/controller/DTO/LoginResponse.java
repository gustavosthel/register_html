package com.register.auth.html.controller.DTO;

public record LoginResponse(String accessToken, Long expiresIn) {
}
