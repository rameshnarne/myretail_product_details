package com.myretail.products.service.impl;

import com.myretail.products.data.IRedisDataClient;
import com.myretail.products.data.RedisKey;
import com.myretail.products.exceptions.ApiServiceException;
import com.myretail.products.helper.CommonHelper;
import com.myretail.products.model.PriceDetails;
import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.model.ProductPriceRequest;
import com.myretail.products.service.IRetrieveProductDetailsService;
import com.myretail.products.service.IUpdateProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductDetailsService implements IUpdateProductDetailsService {

    @Autowired
    private IRetrieveProductDetailsService retrieveProductDetails;

    @Autowired
    private IRedisDataClient redisDataClient;

    @Autowired
    private CommonHelper commonHelper;

    /**
     * UpdateProductDetails service helps to update the Product details in Redis based on productId and Request
     * @param productId
     * @param priceRequest
     * @throws RuntimeException
     * @return ProductDetailsResponse
     */
    @Override
    public void updateProductDetails(String productId, ProductPriceRequest priceRequest) {
        ProductDetailsResponse productDetails = retrieveProductDetails.retrieveProductDetails(productId);
        PriceDetails priceDetails = productDetails.getPriceDetails();
        priceDetails.setValue(priceRequest.getValue());
        priceDetails.setCurrencyCode(priceRequest.getCurrencyCode());
        productDetails.setPriceDetails(priceDetails);
        redisDataClient.saveValue(RedisKey.PRODUCT_DATA_ + productId, commonHelper.convertObjectToString(productDetails));
    }

}
