package com.ecommerce.servicelog.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfig {
    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // ✅ Tạo ObjectMapper có hỗ trợ LocalDateTime
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        // ✅ Tạo JacksonJsonpMapper từ ObjectMapper tuỳ chỉnh
        JacksonJsonpMapper jsonpMapper = new JacksonJsonpMapper(mapper);

        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http")
        ).build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient,
                jsonpMapper // dùng mapper custom
        );

        return new ElasticsearchClient(transport);
    }
}
