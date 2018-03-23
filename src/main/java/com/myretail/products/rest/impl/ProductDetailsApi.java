package com.myretail.products.rest.impl;

import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.model.ProductPriceRequest;
import com.myretail.products.rest.IProductDetailsApi;
import com.myretail.products.service.IRetrieveProductDetailsService;
import com.myretail.products.service.IUpdateProductDetailsService;
import com.myretail.products.validate.ProductIdValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Component
@Slf4j
public class ProductDetailsApi implements IProductDetailsApi {

    @Autowired
    private IRetrieveProductDetailsService retrieveProductDetails;

    @Autowired
    private IUpdateProductDetailsService updateProductDetailsService;

    /**
     * This API method helps to fetch product details from Redis based on the ProductId.
     * ProductId should be Numeric
     * @param productId
     * @return
     */
    @Override
    public ResponseEntity<?> retrieveProductDetails(@ProductIdValid @PathVariable("productId") String productId) {
        log.debug("ProductId Received In Request: {}", productId);
        ProductDetailsResponse productDetails = retrieveProductDetails.retrieveProductDetails(productId);
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

    /**
     * This API method helps to update product details in Redis Server.
     * ProductId should be Numeric and Request should be in valid format
     * @param productId
     * @param priceRequest
     */
    @Override
    public ResponseEntity<?> updateProductDetails(@ProductIdValid @PathVariable("productId") String productId,
                                                  @Valid @RequestBody ProductPriceRequest priceRequest) {
        log.debug("ProductId Received In Request: {}", productId);
        log.debug("Price Update Request: {}", priceRequest.toString());
        updateProductDetailsService.updateProductDetails(productId, priceRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
