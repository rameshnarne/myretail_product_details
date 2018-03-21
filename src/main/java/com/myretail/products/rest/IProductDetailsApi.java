package com.myretail.products.rest;

import com.myretail.products.validate.ProductIdValid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public interface IProductDetailsApi {

    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ProductIdValid
    ResponseEntity<?> retrieveProductDetails(@NotNull @PathVariable String productId);
}
