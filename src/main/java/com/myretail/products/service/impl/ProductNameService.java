package com.myretail.products.service.impl;

import com.myretail.products.data.IRedisDataClient;
import com.myretail.products.helper.CommonHelper;
import com.myretail.products.service.IProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.details.url}")
    private String productNameUrl;

    @Override
    public String getProductName(String productId) {
        ResponseEntity<String> response = restTemplate.exchange(productNameUrl, HttpMethod.GET.GET, null, String.class);
        return commonHelper.extractProductName(response);
    }
}
