package com.cornucopib.http.encapsulation.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求体.
 *
 * @author cornucopib
 * @since 2023/5/21
 */
@NoArgsConstructor
@Data
public class ProductListParams {

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
}
