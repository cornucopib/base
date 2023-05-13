package com.cornucopib.json.genericity;

import com.cornucopib.json.genericity.model.ESResponse;
import com.cornucopib.json.genericity.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 泛型json化
 *
 * @author cornucopib
 * @since 2023/5/13
 */
public class GenericityJsonTest {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        String source = "{\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"data\": [\n" +
                "                {\n" +
                "                    \"name\": \"lw\",\n" +
                "                    \"age\":12\n" +
                "                }\n" +
                "            ],\n" +
                "            \"tst\": \"ddd\",\n" +
                "            \"zz\": \"1\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"success\",\n" +
                "    \"unique_key\": \"abc123\"\n" +
                "}";
        try {
            ESResponse<Person> esResponse = objectMapper.readValue(source, new TypeReference<ESResponse<Person>>() {
            });
            String name = esResponse.getData().get(0).getData().get(0).getName();
            System.out.println("name:"+name+" unique_key:"+esResponse.getUniqueKey());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
