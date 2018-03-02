package com.bao.msmetrics;

import com.soundcloud.prometheus.hystrix.HystrixPrometheusMetricsPublisher;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ConcurrentHashMap;

@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
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
//
//    @Autowired
//    RedisConnectionFactory connectionFactory;
//
//    @Bean
//    @ExportMetricWriter
//    MetricWriter metricWriter(MetricExportProperties export) {
//        return new RedisMetricRepository(connectionFactory,
//                export.getRedis().getPrefix(), export.getRedis().getKey());
//    }
//
//    @Bean
//    @ExportMetricWriter
//    MetricWriter metricWriter(MBeanExporter exporter) {
//        return new JmxMetricWriter(exporter);
//    }

//    @Bean
//    @ExportMetricWriter
//    GaugeWriter gaugeWriter(){
//        return new OpenTsdbGaugeWriter();
//    }

    public static void main(String[] args) {

        HystrixPrometheusMetricsPublisher.register("ms-metrics");

        SpringApplication.run(MsMetricsApplication.class, args);
    }
}
