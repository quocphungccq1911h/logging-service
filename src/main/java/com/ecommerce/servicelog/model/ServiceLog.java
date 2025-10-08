package com.ecommerce.servicelog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "service-log")
public class ServiceLog {
    @Id
    private String id; // <--- Thêm dòng này để làm ID cho Elasticsearch document
    private String service;
    private String level;
    private String message;
    private Map<String, Object> metadata;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public ServiceLog(String service, String level, String message, Map<String, Object> metadata) {
        this.service = service;
        this.level = level;
        this.message = message;
        this.metadata = metadata;
        this.timestamp = LocalDateTime.now();
    }
}
