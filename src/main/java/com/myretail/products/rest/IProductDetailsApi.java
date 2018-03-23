package com.myretail.products.rest;

import com.myretail.products.model.ProductPriceRequest;
import com.myretail.products.validate.ProductIdValid;
import com.myretail.products.validate.ProductRequestValid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public interface IProductDetailsApi {

    @GetMapping(value = "/products/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> retrieveProductDetails(@PathVariable("productId") String productId);

    @PutMapping(value = "/products/{productId}", headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> updateProductDetails(@NotNull @PathVariable("productId") String productId, @RequestBody ProductPriceRequest priceRequest);
}
