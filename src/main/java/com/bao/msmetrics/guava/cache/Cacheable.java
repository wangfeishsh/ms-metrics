package com.bao.msmetrics.guava.cache;

import com.google.common.base.Ticker;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import org.springframework.cache.guava.GuavaCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by nannan on 2018/3/14.
 */
public class Cacheable {

    public static GuavaCache build() {
        return new GuavaCache("ms-metrics",
                CacheBuilder.newBuilder()
                        .recordStats()
                        .maximumSize(1000)
                        .expireAfterWrite(1L, TimeUnit.DAYS)
                        .build());
    }

    public static void main(String args[]) {

        LoadingCache<String,String> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(100L)
                .expireAfterWrite(1L, TimeUnit.DAYS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String s) throws Exception {
                        return null;
                    }
                });

        GuavaCache guavaCache = build();
        guavaCache.getNativeCache().stats().hitCount();

    }
}
