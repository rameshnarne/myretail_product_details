package com.myretail.products.service.impl;

import com.myretail.products.data.IRedisDataClient;
import com.myretail.products.data.RedisKey;
import com.myretail.products.helper.CommonHelper;
import com.myretail.products.service.IProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductNameService helps to fetch the ProductName from External Site.
 * Since it is throwing HTTP Status code as 301 (Temporarely Moved), created a pretending service that fetch the
 * Product Name from Redis and update the response.
 */
@Service
public class ProductNameService implements IProductNameService{

    @Autowired
    private IRedisDataClient redisDataClient;

    @Autowired
    private CommonHelper commonHelper;

    @Override
    public String getProductName(String productId) {
        return redisDataClient.getValue(RedisKey.PRODUCT_NAME_ + productId);
    }
}
