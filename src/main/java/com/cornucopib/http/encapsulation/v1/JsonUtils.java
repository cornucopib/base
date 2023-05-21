package com.cornucopib.http.encapsulation.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具类.
 *
 * @author cornucopib
 * @since 2023/5/19
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T string2Obj(String str, TypeReference<T> typeReference){
        try {
            return (T)(typeReference.getType().equals(String.class)? str : objectMapper.readValue(str,typeReference));
        } catch (Exception e) {
            return null;
        }
    }
}
