package com.codekeys.annonce_backend.authentification;

import com.codekeys.annonce_backend.securite.JwtService;
import com.codekeys.annonce_backend.utilisateur.Utilisateur;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthentificationResponse authenticate(@Valid AuthentificationRequest authenticationRequest) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );
        var claims = new HashMap<String, Object>();
        var user = ((Utilisateur) auth.getPrincipal());
        claims.put("fullName", user.fullName());
        var jwtToken = this.jwtService.generateToken(claims, user);
        return AuthentificationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
