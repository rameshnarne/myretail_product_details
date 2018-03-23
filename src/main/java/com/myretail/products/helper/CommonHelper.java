package com.myretail.products.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.products.exceptions.ApiServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class CommonHelper {

    /**
     * This method helps to convert an Object into String.
     * @throws ApiServiceException
     * @param value
     * @return
     */
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
}
