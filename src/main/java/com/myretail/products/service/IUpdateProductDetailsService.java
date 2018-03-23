package com.myretail.products.service;

import com.myretail.products.model.ProductPriceRequest;

@FunctionalInterface
public interface IUpdateProductDetailsService {

    void updateProductDetails(String productId, ProductPriceRequest priceRequest);
}
