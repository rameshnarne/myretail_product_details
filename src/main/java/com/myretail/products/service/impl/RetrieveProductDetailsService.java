package com.myretail.products.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.products.constants.ProductDetailsConstants;
import com.myretail.products.data.IRedisDataClient;
import com.myretail.products.data.RedisKey;
import com.myretail.products.exceptions.ApiServiceException;
import com.myretail.products.exceptions.ErrorCodeKeys;
import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.service.IRetrieveProductDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
@Slf4j
public class RetrieveProductDetailsService implements IRetrieveProductDetailsService {

    @Autowired
    private ProductNameService productNameService;

    @Autowired
    private IRedisDataClient redisDataClient;

    /**
     * RetrieveProductDetails service helps to fetch the Product details from Redis based on productId.
     * @param productId
     * @throws ApiServiceException, if no data found or for any RuntimeExceptions
     * @return ProductDetailsResponse
     */
    @Override
    public ProductDetailsResponse retrieveProductDetails(String productId) {
        String jsonValue = redisDataClient.getValue(RedisKey.PRODUCT_DATA_ + productId);
        if(StringUtils.isEmpty(jsonValue)) {
            throw new ApiServiceException(ProductDetailsConstants.PRODUCT_NOT_AVAILABLE,
                    ErrorCodeKeys.INVALID_PRODUCT_ID.name(), HttpStatus.NOT_FOUND);
        }
        String productName = productNameService.getProductName(productId);
        ProductDetailsResponse response = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        try {
            response = mapper.readValue(jsonValue, ProductDetailsResponse.class);
            response.setName(productName);
        } catch (IOException e) {
            log.error("Exception while reading Product Name: {}", e.getMessage());
            throw new ApiServiceException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
