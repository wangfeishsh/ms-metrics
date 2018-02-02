package com.bao.msmetrics;

import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by baochunyu on 2018/2/1.
 */
@Component
public class MetricService implements PublicMetrics {
    @Override
    public Collection<Metric<?>> metrics() {
        List<Metric<?>> list = new ArrayList<>();
        Metric m
                = new Metric("myMetric", System.currentTimeMillis());
        list.add(m);
        return list;
    }
}
