package com.cornucopib.http.encapsulation.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * response.
 *
 * @author cornucopib
 * @since 2023/5/21
 */
@NoArgsConstructor
@Data
public class ProductListResponse {


    @JsonProperty("code")
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private List<DataDTO> data;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        @JsonProperty("id")
        private String id;
        @JsonProperty("status")
        private String status;
        @JsonProperty("title")
        private String title;
        @JsonProperty("price")
        private Integer price;
        @JsonProperty("stock")
        private Integer stock;
        @JsonProperty("description")
        private String description;
        @JsonProperty("sales")
        private Integer sales;
        @JsonProperty("imgUrl")
        private String imgUrl;
        @JsonProperty("promoModel")
        private Object promoModel;
    }
}
