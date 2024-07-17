package com.example.ResourceServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Configuration
public class ResourceServerConfig {
    private static final String SECRET_KEY = "mySecretKey123912738aopsgjnspkmndfsopkvajoirjg94gf2opfng2moknm";
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    String jwkSetUri;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/secret").hasAuthority("SCOPE_read:secret")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.decoder(jwtDecoder()))
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        System.out.println("Attempting to create JwtDecoder with JWK Set URI: " + this.jwkSetUri);
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        byte[] apiKeySecretBytes = Base64.getDecoder().decode(SECRET_KEY);
//        SecretKey secretKey = new SecretKeySpec(apiKeySecretBytes, "HmacSHA256");
//
//        return NimbusJwtDecoder.withSecretKey(secretKey).build();
//    }
}
