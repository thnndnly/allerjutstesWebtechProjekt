package com.example.potcontroll.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// https://github.com/Barrique-v1/BucksBuddyBackend/blob/main/src/main/java/com/bucksbuddy/bucksbuddy/config/SecurityConfig.java
@Configuration
public class PasswordEncoderConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
