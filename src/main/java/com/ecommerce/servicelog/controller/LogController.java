package com.ecommerce.servicelog.controller;

import com.ecommerce.servicelog.model.ServiceLog;
import com.ecommerce.servicelog.service.LogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<ServiceLog> createLog(@RequestBody ServiceLog log) {
        ServiceLog saved = logService.save(log);
        return ResponseEntity.ok(saved);
    }
}
