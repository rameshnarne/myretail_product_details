package com.myretail.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myretail.products.constants.ProductDetailsConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class ProductPriceRequest implements Serializable {
    private static final long serialVersionUID = 1485357963313009468L;

    @NotNull(message = ProductDetailsConstants.PRODUCT_PRICE_MISSING)
    @Digits(integer = 8, fraction = 4, message = ProductDetailsConstants.INVALID_PRICE)
    private BigDecimal value;

    @NotNull(message = ProductDetailsConstants.CURRENCY_CODE_MISSING)
    @Pattern(regexp = "[a-zA-Z]{3}", message = ProductDetailsConstants.INVALID_CURRENCY)
    @JsonProperty("currency_code")
    private String currencyCode;
}
