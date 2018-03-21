package com.myretail.products.service.impl;

import com.myretail.products.entity.ProductDetailsEntity;
import com.myretail.products.model.PriceDetails;
import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.repository.IProductDetailsRepository;
import com.myretail.products.service.IRetrieveProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetrieveProductDetailsService implements IRetrieveProductDetailsService {

    @Autowired
    private ProductNameService productNameService;

    @Autowired
    private IProductDetailsRepository productDetailsRepository;

    @Override
    public ProductDetailsResponse retrieveProductDetails(String productId) {

        Optional<ProductDetailsEntity> productDetailsEntity = productDetailsRepository.findById(productId);
        ProductDetailsResponse productDetailsResponse = new ProductDetailsResponse();
        if(productDetailsEntity.isPresent()){
            String productName = productNameService.getProductName(productId);
            productDetailsResponse.setId(productDetailsEntity.get().getId());
            productDetailsResponse.setName(productName);
            PriceDetails priceDetails = new PriceDetails();
            priceDetails.setCurrencyCode(productDetailsEntity.get().getPriceDetailsEntity().getCurrencyCode());
            priceDetails.setValue(productDetailsEntity.get().getPriceDetailsEntity().getValue());
            productDetailsResponse.setPriceDetails(priceDetails);
        }
        return productDetailsResponse;
    }
}
