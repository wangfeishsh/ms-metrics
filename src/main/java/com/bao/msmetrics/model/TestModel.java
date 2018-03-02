package com.bao.msmetrics.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by baochunyu on 2018/1/11.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestModel {
    private String id;
    private String name;
    private Integer number;
}
