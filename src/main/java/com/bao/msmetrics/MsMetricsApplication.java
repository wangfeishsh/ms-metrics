package com.bao.msmetrics;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.ExportMetricWriter;
import org.springframework.boot.actuate.metrics.statsd.StatsdMetricWriter;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MsMetricsApplication {

	@Value("${spring.application.name:application}.${random.value:0000}")
	private String prefix = "metrics";

//	@Bean
//	@ExportMetricWriter
//	MetricWriter metricWriter() {
//		return new StatsdMetricWriter(prefix, "localhost", 8125);
//	}

	public static void main(String[] args) {
		SpringApplication.run(MsMetricsApplication.class, args);
	}
}
