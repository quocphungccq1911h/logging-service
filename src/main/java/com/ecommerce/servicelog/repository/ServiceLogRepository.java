package com.ecommerce.servicelog.repository;

import com.ecommerce.servicelog.model.ServiceLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceLogRepository extends ElasticsearchRepository<ServiceLog, String> {
}
