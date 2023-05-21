package com.cornucopib.http.encapsulation.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class HttpClientDemo {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("http://localhost:8888/product/create_batch");

        try {
            // 设置请求体参数
            ObjectMapper objectMapper = new ObjectMapper();
            List<ProductListParams> productListParamsList=new ArrayList<>();
            ProductListParams productListParams = new ProductListParams();
            productListParams.setStatus("3");
            productListParams.setTitle("apple");
            productListParams.setPrice(8000);
            productListParams.setStock(1000);
            productListParams.setDescription("华为手机");
            productListParams.setSales(1);
            productListParams.setImgUrl("http://www.baidu.com");
            productListParamsList.add(productListParams);
            String requestBodyJson = objectMapper.writeValueAsString(productListParamsList);
            StringEntity stringEntity = new StringEntity(requestBodyJson);

            // 设置请求头
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(stringEntity);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String jsonResponse = EntityUtils.toString(entity);
                // 解析响应
                TypeReference<ProductListResponse> typeReference = new TypeReference<ProductListResponse>() {};
                ProductListResponse productListResponseObj = objectMapper.readValue(jsonResponse, typeReference);
                // 使用 responseObj 进行后续操作
                System.out.println(productListResponseObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

