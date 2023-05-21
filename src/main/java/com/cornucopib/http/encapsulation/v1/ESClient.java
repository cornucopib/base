package com.cornucopib.http.encapsulation.v1;

import com.alibaba.fastjson.JSON;
import com.cornucopib.http.encapsulation.demo.ProductListResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Optional;

/**
 * HttpClient工具类.
 *
 * @author cornucopib
 * @since 2023/5/21
 */
public class ESClient {

    public static <T> Optional<T> request(String url, ESParams esParams) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        Optional responseOptional = Optional.empty();

        try {
            // 设置请求体参数
            ObjectMapper objectMapper = new ObjectMapper();
            httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(esParams)));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonResponse = EntityUtils.toString(entity);
                // 解析响应
                TypeReference<ProductListResponse> typeReference = new TypeReference<ProductListResponse>() {
                };
                ProductListResponse productListResponseObj = objectMapper.readValue(jsonResponse, typeReference);
                responseOptional = Optional.of(productListResponseObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseOptional;
    }


}
