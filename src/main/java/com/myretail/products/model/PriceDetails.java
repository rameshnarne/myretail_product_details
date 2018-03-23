package com.myretail.products.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PriceDetails implements Serializable{
   private static final long serialVersionUID = -5234280476066339720L;

   private double value;
   private String currencyCode;
}
