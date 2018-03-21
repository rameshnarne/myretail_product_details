package com.myretail.products.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProductDetailsResponse implements Serializable{
    private static final long serialVersionUID = -6005038576023368628L;

    private String id;
    private String name;
    private PriceDetails priceDetails;
}
