package com.myretail.products.data;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRedisDataClient {

    void saveValue(String key, String value);
    String getValue(String key);
}
