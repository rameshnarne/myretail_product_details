package com.myretail.products.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class ProductDetailsEntity implements Serializable {
    private static final long serialVersionUID = 7660439602012350833L;

    private String id;
    private PriceDetailsEntity priceDetailsEntity;
}
