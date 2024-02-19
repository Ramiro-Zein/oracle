package com.crud.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<UserOracle> getAllUsers() {
        String sql = "SELECT * FROM USER_ORACLE";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(UserOracle.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOracle> getUserById(@PathVariable Long id) {
        String sql = "SELECT * FROM USER_ORACLE WHERE ID_USER = ?";
        List<UserOracle> users = jdbcTemplate.query(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(UserOracle.class));

        if (users.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(users.get(0));
        }
    }
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserOracle newUser) {
        String sql = "INSERT INTO USER_ORACLE (USER_NAME, CORREO_USER, CONTRASENA_USER, CODIGO_POSTAL_USER, DIRECCION_USER, TELEFONO_USER, EDAD_USER) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, newUser.getUserName(), newUser.getCorreoUser(), newUser.getContrasenaUser(), newUser.getCodigoPostalUser(), newUser.getDireccionUser(), newUser.getTelefonoUser(), newUser.getEdadUser());
            return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating user");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserOracle updatedUser) {
        String sql = "UPDATE USER_ORACLE SET CORREO_USER = ?, CONTRASENA_USER = ?,CODIGO_POSTAL_USER = ?, DIRECCION_USER = ?, TELEFONO_USER = ?, EDAD_USER = ? WHERE ID_USER = ?";

        try {
            jdbcTemplate.update(sql, updatedUser.getCorreoUser(), updatedUser.getCodigoPostalUser(), updatedUser.getDireccionUser(), updatedUser.getTelefonoUser(), updatedUser.getEdadUser(), id);
            return ResponseEntity.status(HttpStatus.OK).body("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String sql = "DELETE FROM USER_ORACLE WHERE ID_USER = ?";

        try {
            jdbcTemplate.update(sql, id);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
        }
    }

}
