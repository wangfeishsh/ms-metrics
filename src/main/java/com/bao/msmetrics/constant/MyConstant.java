package com.bao.msmetrics.constant;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by nannan on 2018/3/16.
 */
public class MyConstant {
    public static final RateLimiter rateLimiter = RateLimiter.create(2);
}
