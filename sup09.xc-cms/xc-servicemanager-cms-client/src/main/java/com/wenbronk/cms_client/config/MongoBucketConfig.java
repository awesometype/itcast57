package com.wenbronk.cms_client.config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-12 14:56
 * description:
 */
@Configuration
public class MongoBucketConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }

    @Bean
    public GridFSBucket gridFSBucket(MongoClient mongoClient, MongoProperties mongoProperties) {
        MongoDatabase database = mongoClient.getDatabase(mongoProperties.getDatabase());
        return GridFSBuckets.create(database);
    }

}
