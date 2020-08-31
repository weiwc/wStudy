package com.weiwc.study.wstudy.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author weichen
 * @description: TODO
 * @create 2020-08-24 21:11
 */
public class UtilProperties {
    // 根据经度或者时区计算当地时间
    private Double latitude = 120d;

    private int zone;

    private String pattern = "yyyy-MM-dd HH:mm:ss";
}
