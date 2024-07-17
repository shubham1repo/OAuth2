package com.example.AuthorizationServer.controller;

import com.example.AuthorizationServer.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.nio.CharBuffer;

@RestController
public class Controller {

    private final JdbcTemplate jdbcTemplate;

    public Controller(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Autowired
    DataSource dataSource;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        userDetailsManager.createUser(
//                User.withUsername(userDto.getUsername())
//                        .password(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())))
//                        .roles("USER")
////                    .disabled(false)
//                        .build()
//        );
//
//        return ResponseEntity.ok("response");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());

        // Save user details to database
        String sql = "INSERT INTO users (username, password, enabled, email, location) VALUES (?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO authorities (username, authority) VALUES (?, ?)";
        jdbcTemplate.update(sql, userDto.getUsername(), encodedPassword,true, userDto.getEmail(), userDto.getLocation());
        jdbcTemplate.update(sql2, userDto.getUsername(),"ROLE_USER");
        return ResponseEntity.ok("User registered successfully");
//service.register(userDto);
//return new ResponseEntity<>(userDto,HttpStatus.CREATED);
    }
}
