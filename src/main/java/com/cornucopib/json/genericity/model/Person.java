package com.cornucopib.json.genericity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Person类.
 *
 * @author cornucopib
 * @since 2023/5/13
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

    private String name;
}
