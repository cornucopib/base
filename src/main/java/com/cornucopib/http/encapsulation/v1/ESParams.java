package com.cornucopib.http.encapsulation.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * es params.
 *
 * @author cornucopib
 * @since 2023/5/21
 */
public class ESParams {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("tenant_id")
    private String tenantId;
    @JsonProperty("custom_params")
    private List<CustomParams> customParams;

    private ESParams(Builder builder) {
        this.userId = builder.userId;
        this.tenantId = builder.tenantId;
        this.customParams = builder.customParams;
    }


    public static class Builder {

        private String userId;

        private String tenantId;

        private List<CustomParams> customParams;

        public ESParams build() {
            if (userId == null || "".equals(userId)) {
                this.userId = "x";
            }
            return new ESParams(this);
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTenantId(String tenantId) {
            this.tenantId = tenantId;
            return this;
        }

        public Builder setCustomParams(List<CustomParams> customParams) {
            this.customParams = customParams;
            return this;
        }

        public Builder addCustomParam(String name, String key) {
            addCustomParam(new CustomParams(name, key));
            return this;
        }

        public Builder addCustomParam(CustomParams customParams) {
            if (this.customParams == null) {
                this.customParams = new ArrayList<>();
            }
            this.customParams.add(customParams);
            return this;
        }
    }





}
