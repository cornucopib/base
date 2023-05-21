package com.cornucopib.http.encapsulation.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cornucopib
 * @since 2023/5/21
 */
public class Test {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        ESParams esParams = ESParams.Builder.create()
                .addCustomParam("key1","value1")
                .addCustomParam("key2","value2")
                .setCustomParams(null)
                .setTenantId("test").build();
        System.out.println(objectMapper.writeValueAsString(esParams));
    }



}
