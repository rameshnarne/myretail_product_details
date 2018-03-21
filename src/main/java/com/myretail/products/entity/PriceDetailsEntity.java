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
public class PriceDetailsEntity implements Serializable {
    private static final long serialVersionUID = -3830506565943666421L;

    private Double value;
    private String currencyCode;
}
