package com.ecommerce.servicelog.controller;

import com.ecommerce.servicelog.model.ServiceLog;
import com.ecommerce.servicelog.service.ElasticLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
public class LogController {
    private final ElasticLogService elasticLogService;

    public LogController(ElasticLogService elasticLogService) {
        this.elasticLogService = elasticLogService;
    }

    @PostMapping
    public ResponseEntity<String> createLog(@Valid @RequestBody ServiceLog log) {
        log.setTimestamp(java.time.LocalDateTime.now());
        elasticLogService.save(log);
        return ResponseEntity.ok("Log saved");
    }
}
