package com.myretail.products.rest;

import com.myretail.products.model.ProductPriceRequest;
import com.myretail.products.validate.ProductIdValid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * This API class helps to perform Read and Update operation for MyRetails Product Details.
 */
@RestController
@Validated
public interface IProductDetailsApi {

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> retrieveProductDetails(@ProductIdValid @PathVariable("productId") String productId);

    @PutMapping(value = "/products/{productId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> updateProductDetails(@ProductIdValid @PathVariable("productId") String productId,
                                           @Valid @RequestBody ProductPriceRequest priceRequest);
}
