package com.myretail.products.service;

import com.myretail.products.model.ProductDetailsResponse;

@FunctionalInterface
public interface IRetrieveProductDetailsService {

    ProductDetailsResponse retrieveProductDetails(String productId);
}
