package com.cornucopib.json.genericity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * es 响应
 *
 * @author cornucopib
 * @since 2023/5/13
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ESResponse<T> {

    @JsonProperty("data")
    private List<DataDTO<T>> data;
    @JsonProperty("status")
    private String status;
    @JsonProperty("unique_key")
    private String uniqueKey;

    @NoArgsConstructor
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataDTO<T> {

        @JsonProperty("data")
        private List<T> data;
    }
}
