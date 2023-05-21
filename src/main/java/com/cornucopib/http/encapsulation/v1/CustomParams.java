package com.cornucopib.http.encapsulation.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class CustomParams {
        @JsonProperty("custom_name")
        private String customName;
        @JsonProperty("custom_value")
        private String customValue;

        public CustomParams(String customName, String customValue) {
            this.customName = customName;
            this.customValue = customValue;
        }

        public String getCustomName() {
            return customName;
        }

        public void setCustomName(String customName) {
            this.customName = customName;
        }

        public String getCustomValue() {
            return customValue;
        }

        public void setCustomValue(String customValue) {
            this.customValue = customValue;
        }
    }