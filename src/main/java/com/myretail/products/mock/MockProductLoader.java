package com.myretail.products.mock;

import com.myretail.products.data.IRedisDataClient;
import com.myretail.products.data.RedisKey;
import com.myretail.products.helper.CommonHelper;
import com.myretail.products.model.PriceDetails;
import com.myretail.products.model.ProductDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

/**
 * Purpose of this class is to load the default product details for validation purpose.
 * This class helps to insert data in Redis for PRODUCT_DATA and PRODUCT_NAME Keys
 */
@Component
public class MockProductLoader {

    @Autowired
    private IRedisDataClient redisDataClient;

    @Autowired
    private CommonHelper commonHelper;

    @PostConstruct
    private void init() throws RuntimeException {
        this.loadProductNames();
        this.loadProductDetails();
    }

    private void loadProductDetails() throws RuntimeException {
        ProductDetailsResponse productDetailsResponse = new ProductDetailsResponse();
        PriceDetails priceDetails = new PriceDetails();
        priceDetails.setCurrencyCode("USD");
        priceDetails.setValue(new BigDecimal("13.49"));
        productDetailsResponse.setPriceDetails(priceDetails);
        productDetailsResponse.setId("13860428");
        redisDataClient.saveValue(RedisKey.PRODUCT_DATA_ + productDetailsResponse.getId(),
                                    commonHelper.convertObjectToString(productDetailsResponse));

    }

    private void loadProductNames() throws RuntimeException {
        redisDataClient.saveValue(RedisKey.PRODUCT_NAME_ + "13860428", "The Big Lebowski (Blu-ray) (Widescreen)");
    }
}
