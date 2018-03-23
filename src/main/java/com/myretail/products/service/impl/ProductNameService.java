package com.myretail.products.service.impl;

import com.myretail.products.helper.CommonHelper;
import com.myretail.products.service.IProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductNameService implements IProductNameService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CommonHelper commonHelper;

    @Override
    public String getProductName(String productId) {
        String externalURL = "";
        return commonHelper.readValueFromJsonResponseEntity(restTemplate.getForEntity(externalURL, String.class));
    }
}
