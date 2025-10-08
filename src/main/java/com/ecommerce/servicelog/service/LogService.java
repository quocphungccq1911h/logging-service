package com.ecommerce.servicelog.service;

import com.ecommerce.servicelog.model.ServiceLog;
import com.ecommerce.servicelog.repository.ServiceLogRepository;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final ServiceLogRepository repository;

    public LogService(ServiceLogRepository repository) {
        this.repository = repository;
    }

    public ServiceLog save(ServiceLog log) {
        return repository.save(log);
    }
}
