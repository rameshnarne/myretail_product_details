package com.myretail.products.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.products.exceptions.ApiServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Objects;

@Slf4j
public class CommonHelper {

    public String convertObjectToString(Object value) {
        String jsonValue = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonValue = mapper.writeValueAsString(value);
        } catch (JsonProcessingException exp) {
            throw new ApiServiceException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                    HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return jsonValue;
    }

    public String readValueFromJsonResponseEntity(ResponseEntity<String> responseEntity) {
        String jsonValue = "";
        if (Objects.nonNull(responseEntity)
                && HttpStatus.OK.equals(responseEntity.getStatusCode())){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = null;
            try {
                root = mapper.readTree(responseEntity.getBody());
                jsonValue = root.at("/product/item/product_description/title").asText();
            } catch (IOException e) {
                log.error("Exception while reading Product Name: {}", e.getMessage());
                e.printStackTrace();
            }
        }
        return jsonValue;
    }
}
