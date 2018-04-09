package com.bao.msmetrics;

import com.bao.msmetrics.listener.MyListener;
import com.soundcloud.prometheus.hystrix.HystrixPrometheusMetricsPublisher;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;

@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
@EnableScheduling
@SpringBootApplication
public class MsMetricsApplication {

    @Value("${spring.application.name:application}.${random.value:0000}")
    private String prefix = "metrics";

    @Bean
    public MyListener myListener(){
        return new MyListener();
    }

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

        Calendar calendar =Calendar.getInstance();
        SpringApplication.run(MsMetricsApplication.class, args);

        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        Clock c1 = Clock.systemUTC(); //系统默认UTC时钟（当前瞬时时间 System.currentTimeMillis()）
        System.out.println(c1.millis()); //每次调用将返回当前瞬时时间（UTC）

        LocalDateTime localDateTime1 = LocalDateTime.now(c1);

        System.out.println(localDateTime1);
    }
}
