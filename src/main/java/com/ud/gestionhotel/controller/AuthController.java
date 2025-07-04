package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String role = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(auth -> auth.getAuthority().replace("ROLE_", ""))
                    .orElse("USER");

            String token = jwtUtil.generateToken(userDetails.getUsername(), role);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("username", userDetails.getUsername());
            response.put("role", role);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Credenciales incorrectas: " + e.getMessage());
        }
    }
}
