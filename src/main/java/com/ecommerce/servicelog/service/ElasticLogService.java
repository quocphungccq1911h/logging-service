package com.ecommerce.servicelog.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.ecommerce.servicelog.model.ServiceLog;
import org.springframework.stereotype.Service;


@Service
public class ElasticLogService {
    private final ElasticsearchClient client;

    public ElasticLogService(ElasticsearchClient client) {
        this.client = client;
    }

    public void save(ServiceLog log) {
        try {
            IndexResponse response = client.index(i -> i
                    .index("service-log")
                    .document(log));
            System.out.println("Saved log with id " + response.id());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
