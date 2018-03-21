package com.myretail.products.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.products.service.IProductNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;

@Service
public class ProductNameService implements IProductNameService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getProductName(String productId) {
        String externalURL = "";
        ResponseEntity<String> response
                = restTemplate.getForEntity(externalURL, String.class);
        if (Objects.nonNull(response)
                && HttpStatus.OK.equals(response.getStatusCode())){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = null;
            try {
                root = mapper.readTree(response.getBody());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return root.at("/product/item/product_description/title").asText();
        } else return "";
    }
}
