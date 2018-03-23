package com.myretail.products.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.products.constants.ProductDetailsConstants;
import com.myretail.products.data.IRedisDataClient;
import com.myretail.products.exceptions.ApiServiceException;
import com.myretail.products.exceptions.ErrorCodeKeys;
import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.service.IRetrieveProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RetrieveProductDetailsService implements IRetrieveProductDetailsService {

    @Autowired
    private ProductNameService productNameService;

    @Autowired
    private IRedisDataClient redisDataClient;

    @Override
    public ProductDetailsResponse retrieveProductDetails(String productId) {
        String jsonValue = redisDataClient.getValue(productId);
        if(StringUtils.isEmpty(jsonValue)) {
            throw new ApiServiceException(ProductDetailsConstants.PRODUCT_NOT_AVAILABLE,
                    ErrorCodeKeys.INVALID_PRODUCT_ID.name(), HttpStatus.NOT_FOUND);
        }
        ProductDetailsResponse response = null;
        response = new ObjectMapper().convertValue(jsonValue, ProductDetailsResponse.class);
        return response;
    }

}
