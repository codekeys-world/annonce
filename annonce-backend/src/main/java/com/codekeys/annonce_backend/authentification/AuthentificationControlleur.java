package com.codekeys.annonce_backend.authentification;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthentificationControlleur {
    private final AuthentificationService authentificationService;

    @PostMapping("/authenticate")
    public ResponseEntity<@NonNull AuthentificationResponse> authentification(@RequestBody @Valid AuthentificationRequest authentificationRequest) {
        return ResponseEntity.ok(
            this.authentificationService.authenticate(authentificationRequest)
        );
    }
}
