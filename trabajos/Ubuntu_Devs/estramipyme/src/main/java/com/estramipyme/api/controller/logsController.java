package com.estramipyme.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estramipyme.api.service.LogService;
import com.estramipyme.api.dto.LogDto;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogsController {

    private final LogService logService;

    @Autowired
    public LogsController(LogService logService) {
        this.logService = logService;
    }

    // Obtener todos los logs
    @GetMapping
    public ResponseEntity<List<LogDto>> getAllLogs() {
        List<LogDto> logs = logService.getAllLogs();
        return ResponseEntity.ok(logs);
    }

    // Obtener un log específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<LogDto> getLog(@PathVariable Integer id) {
        LogDto log = logService.getLogById(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo log (opcional, dependiendo de tu caso de uso)
    @PostMapping
    public ResponseEntity<LogDto> createLog(@RequestBody LogDto logDto) {
        LogDto createdLog = logService.createLog(logDto);
        return ResponseEntity.status(201).body(createdLog);
    }

    // Eliminar un log por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Integer id) {
        logService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
