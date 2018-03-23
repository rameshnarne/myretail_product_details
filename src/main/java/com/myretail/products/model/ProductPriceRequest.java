package com.myretail.products.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @NotNull(message = "Product Price Is Missing")
    @Digits(integer = 8, fraction = 4, message = "Invalid Price Details")
    private BigDecimal value;

    @NotNull(message = "Currency Code Is Missing")
    @Pattern(regexp = "[a-zA-Z]{3}", message = "Invalid Currency Code")
    @JsonProperty("currency_code")
    private String currencyCode;
}
