package com.myretail.products.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class ProductPriceRequest implements Serializable {
    private static final long serialVersionUID = 1485357963313009468L;

    private double value;
    private String currencyCode;
}
