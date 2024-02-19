package com.crud.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Object> loginUser(@RequestBody UserOracle user) {
        String sql = "SELECT * FROM USER_ORACLE WHERE CORREO_USER = ?";
        List<UserOracle> users = jdbcTemplate.query(sql, new Object[]{user.getCorreoUser()}, BeanPropertyRowMapper.newInstance(UserOracle.class));

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        } else {
            UserOracle existingUser = users.get(0);
            if (user.getContrasenaUser().equals(existingUser.getContrasenaUser())) {
                return ResponseEntity.status(HttpStatus.OK).body(existingUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
            }
        }

    }

    private boolean isPasswordValid(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
