参考项目
[ms-metrics](https://github.com/wangfeishsh/ms-metrics)

## spring actuator
[Spring Boot Actuator监控端点小结](http://blog.didispace.com/spring-boot-actuator-1/)

```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
```
#### Metrics
#### Gauge
#### Counter
#### 自定义性能指标

## spring prometheus
```
<dependency>
			<groupId>io.prometheus</groupId>
			<artifactId>simpleclient_spring_boot</artifactId>
			<version>0.2.0</version>
		</dependency>
```
## TSDB (Time Series Database)

下面介绍下时序数据库的一些基本概念(不同的时序数据库称呼略有不同)。

metric: 度量，相当于关系型数据库中的table。

data point: 数据点，相当于关系型数据库中的row。

timestamp：时间戳，代表数据点产生的时间。

field: 度量下的不同字段。比如位置这个度量具有经度和纬度两个field。一般情况下存放的是会随着时间戳的变化而变化的数据。

tag: 标签，或者附加信息。一般存放的是并不随着时间戳变化的属性信息。timestamp加上所有的tags可以认为是table的primary key。

如下图，度量为Wind，每一个数据点都具有一个timestamp，两个field：direction和speed，两个tag：sensor、city。它的第一行和第三行，存放的都是sensor号码为95D8-7913的设备，属性城市是上海。随着时间的变化，风向和风速都发生了改变，风向从23.4变成23.2;而风速从3.4变成了3.3。

![](http://img3.donews.com/uploads/img3/img_pic_1494301251_1.png)

## Prometheus

[Prometheus data model](https://prometheus.io/docs/concepts/data_model/)

prometheus config
```
scrape_configs:
  # The job name is added as a label `job=<job_name>` to any timeseries scraped from this config.
  - job_name: 'prometheus'

    # metrics_path defaults to '/metrics'
    # scheme defaults to 'http'.
    metrics_path: '/prometheus'
    static_configs:
      - targets: ['localhost:9988']
  - job_name: 'prometheus2'

    # metrics_path defaults to '/metrics'
    # scheme defaults to 'http'.
    metrics_path: '/prometheus'
    static_configs:
      - targets: ['192.168.14.36:9988']
```

## Grafana
![](http://docs.yupaopao.cn/Public/Uploads/2018-02-02/5a73ad1682074.png)


## 问题
1. Prometheus服务自动发现
[advanced-service-discovery](https://prometheus.io/blog/2015/06/01/advanced-service-discovery/)

2. Prometheus单机服务

mem/1024
mem_free/1024

(https://prometheus.io/docs/prometheus/latest/querying/basics/)