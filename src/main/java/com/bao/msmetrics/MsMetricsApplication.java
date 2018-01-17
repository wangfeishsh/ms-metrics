package com.bao.msmetrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.export.MetricExportProperties;
import org.springframework.boot.actuate.metrics.repository.redis.RedisMetricRepository;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@SpringBootApplication
public class MsMetricsApplication {

    @Value("${spring.application.name:application}.${random.value:0000}")
    private String prefix = "metrics";

//	@Bean
//	@ExportMetricWriter
//	MetricWriter metricWriter() {
//		return new StatsdMetricWriter(prefix, "localhost", 8125);
//	}

    @Autowired
    RedisConnectionFactory connectionFactory;

    @Bean
    @ExportMetricWriter
    MetricWriter metricWriter(MetricExportProperties export) {
        return new RedisMetricRepository(connectionFactory,
                export.getRedis().getPrefix(), export.getRedis().getKey());
    }

    public static void main(String[] args) {
        SpringApplication.run(MsMetricsApplication.class, args);
    }
}
