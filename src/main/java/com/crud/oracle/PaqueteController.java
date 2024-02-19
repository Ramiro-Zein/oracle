package com.crud.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/paquetes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaqueteController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<PaqueteUser> getAllPaquetes() {
        String sql = "SELECT * FROM PAQUETE_USER";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(PaqueteUser.class));
    }

    @GetMapping("/user/{id}")
    public List<PaqueteUser> getPaquetesByUserId(@PathVariable Long id) {
        String sql = "SELECT * FROM PAQUETE_USER WHERE ID_USER_PQ = ?";
        return jdbcTemplate.query(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(PaqueteUser.class));
    }

    @GetMapping("/user/{userId}/{folio}")
    public List<PaqueteUser> getPaquetesByUserIdEspecifico(@PathVariable Long userId, @PathVariable Long folio) {
        String sql = "SELECT * FROM PAQUETE_USER WHERE ID_USER_PQ = ? AND FOLIO_PQ = ?";
        return jdbcTemplate.query(sql, new Object[]{userId, folio}, BeanPropertyRowMapper.newInstance(PaqueteUser.class));
    }

    @PutMapping("/user/{userId}/{folio}")
    public ResponseEntity<String> updatePaquete(@PathVariable Long userId, @PathVariable Long folio, @RequestBody PaqueteUser updatedPaquete) {
        String sql = "UPDATE PAQUETE_USER SET FECHA_PQ = ?, REMITENTE_PQ = ?, DESTINATARIO_PQ = ?, DIRECCION_DESTINATARIO_PQ = ?, TEL_DESTINATARIO_PQ = ?, PESO_PQ = ?, OBSERVACIONES_PQ = ?, COSTO_ENVIO_PQ = ? WHERE FOLIO_PQ = ?";

        try {
            jdbcTemplate.update(sql, updatedPaquete.getFechaPq(), updatedPaquete.getRemitentePq(), updatedPaquete.getDestinatarioPq(), updatedPaquete.getDireccionDestinatarioPq(), updatedPaquete.getTelDestinatarioPq(), updatedPaquete.getPesoPq(), updatedPaquete.getObservacionesPq(), updatedPaquete.getCostoEnvioPq(), folio);
            return ResponseEntity.ok("Paquete updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating paquete");
        }
    }

    @DeleteMapping("/user/{folio}")
    public ResponseEntity<String> deletePaquete(@PathVariable Long folio) {
        String sql = "DELETE FROM PAQUETE_USER WHERE FOLIO_PQ = ?";

        try {
            jdbcTemplate.update(sql, folio);
            return ResponseEntity.ok("Paquete deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting paquete");
        }
    }

    @GetMapping("/{folio}")
    public ResponseEntity<PaqueteUser> getPaqueteByFolio(@PathVariable Long folio) {
        String sql = "SELECT * FROM PAQUETE_USER WHERE FOLIO_PQ = ?";
        List<PaqueteUser> paquetes = jdbcTemplate.query(sql, new Object[]{folio}, BeanPropertyRowMapper.newInstance(PaqueteUser.class));

        if (paquetes.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(paquetes.get(0));
        }
    }

    @PostMapping
    public ResponseEntity<String> createPaquete(@RequestBody PaqueteUser newPaquete) {
        String sql = "INSERT INTO PAQUETE_USER (ID_USER_PQ, FECHA_PQ, REMITENTE_PQ, DESTINATARIO_PQ, DIRECCION_DESTINATARIO_PQ, TEL_DESTINATARIO_PQ, PESO_PQ, OBSERVACIONES_PQ, COSTO_ENVIO_PQ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, newPaquete.getIdUserPq(), newPaquete.getFechaPq(), newPaquete.getRemitentePq(), newPaquete.getDestinatarioPq(), newPaquete.getDireccionDestinatarioPq(), newPaquete.getTelDestinatarioPq(), newPaquete.getPesoPq(), newPaquete.getObservacionesPq(), newPaquete.getCostoEnvioPq());
            return ResponseEntity.status(HttpStatus.CREATED).body("Paquete created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating paquete");
        }
    }


}
