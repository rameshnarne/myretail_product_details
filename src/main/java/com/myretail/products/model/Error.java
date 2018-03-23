package com.myretail.products.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
public class Error implements Serializable {
    private static final long serialVersionUID = 1538810703252302378L;

    private String reasonCode;
    private String description;

}
