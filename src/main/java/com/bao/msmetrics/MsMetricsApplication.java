package com.bao.msmetrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.export.MetricExportProperties;
import org.springframework.boot.actuate.metrics.jmx.JmxMetricWriter;
import org.springframework.boot.actuate.metrics.repository.redis.RedisMetricRepository;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class MsMetricsApplication {

    @Value("${spring.application.name:application}.${random.value:0000}")
    private String prefix = "metrics";

//	@Bean
//	@ExportMetricWriter
//	MetricWriter metricWriter() {
//		return new StatsdMetricWriter(prefix, "localhost", 8125);
//	}

//    @Autowired
//    RedisConnectionFactory connectionFactory;
//
//    @Bean
//    @ExportMetricWriter
//    MetricWriter metricWriter(MetricExportProperties export) {
//        return new RedisMetricRepository(connectionFactory,
//                export.getRedis().getPrefix(), export.getRedis().getKey());
//    }

    @Bean
    @ExportMetricWriter
    MetricWriter metricWriter(MBeanExporter exporter) {
        return new JmxMetricWriter(exporter);
    }

    public static void main(String[] args) {
        SpringApplication.run(MsMetricsApplication.class, args);
    }
}
