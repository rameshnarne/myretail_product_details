package com.myretail.products.rest.impl;

import com.myretail.products.rest.IProductDetailsApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailsApi implements IProductDetailsApi {

    @Override
    public ResponseEntity<?> retrieveProductDetails(String productId) {
        return null;
    }
}
