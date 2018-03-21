package com.myretail.products.service;

import com.myretail.products.model.ProductDetailsResponse;

@FunctionalInterface
public interface IUpdateProductDetailsService {

    void updateProductDetails(ProductDetailsResponse productDetailsResponse);
}
