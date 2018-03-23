package com.myretail.products.rest.impl;

import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.model.ProductPriceRequest;
import com.myretail.products.rest.IProductDetailsApi;
import com.myretail.products.service.IRetrieveProductDetailsService;
import com.myretail.products.service.IUpdateProductDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@Slf4j
public class ProductDetailsApi implements IProductDetailsApi {

    @Autowired
    private IRetrieveProductDetailsService retrieveProductDetails;

    @Autowired
    private IUpdateProductDetailsService updateProductDetailsService;

    @Override
    public ResponseEntity<?> retrieveProductDetails(@PathVariable("productId") String productId) {
        log.debug("ProductId Received In Request: {}", productId);
        ProductDetailsResponse productDetails = retrieveProductDetails.retrieveProductDetails(productId);
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateProductDetails(@PathVariable("productId") String productId, ProductPriceRequest priceRequest) {
        log.debug("ProductId Received In Request: {}", productId);
        log.debug("Price Update Request: {}", priceRequest.toString());
        updateProductDetailsService.updateProductDetails(productId, priceRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
