[Spring Boot Actuator监控端点小结](http://blog.didispace.com/spring-boot-actuator-1/)
[Grafana+Prometheus系统监控之SpringBoot](https://yq.aliyun.com/articles/272542)

```
{
  "mem": 541305,
  "mem.free": 317864,
  "processors": 8,
  "instance.uptime": 33376471,
  "uptime": 33385352,
  "systemload.average": -1,
  "heap.committed": 476672,
  "heap.init": 262144,
  "heap.used": 158807,
  "heap": 3701248,
  "nonheap.committed": 65856,
  "nonheap.init": 2496,
  "nonheap.used": 64633,
  "nonheap": 0,
  "threads.peak": 22,
  "threads.daemon": 20,
  "threads.totalStarted": 26,
  "threads": 22,
  "classes": 7669,
  "classes.loaded": 7669,
  "classes.unloaded": 0,
  "gc.ps_scavenge.count": 7,
  "gc.ps_scavenge.time": 118,
  "gc.ps_marksweep.count": 2,
  "gc.ps_marksweep.time": 234,
  "httpsessions.max": -1,
  "httpsessions.active": 0,
  "gauge.response.beans": 55,
  "gauge.response.env": 10,
  "gauge.response.hello": 5,
  "gauge.response.metrics": 4,
  "gauge.response.configprops": 153,
  "gauge.response.star-star": 5,
  "counter.status.200.beans": 1,
  "counter.status.200.metrics": 3,
  "counter.status.200.configprops": 1,
  "counter.status.404.star-star": 2,
  "counter.status.200.hello": 11,
  "counter.status.200.env": 1
}
```


## JMX

![每个Java开发者都应该知道的5个JDK工具](http://blog.csdn.net/tswc1990/article/details/41344635
![配置Java远程监控授权（Java Mission Control）](http://blog.csdn.net/nysyxxg/article/details/51150636)

oracle java mission control

```
jmc
```


下面介绍下时序数据库的一些基本概念(不同的时序数据库称呼略有不同)。

metric: 度量，相当于关系型数据库中的table。

data point: 数据点，相当于关系型数据库中的row。

timestamp：时间戳，代表数据点产生的时间。

field: 度量下的不同字段。比如位置这个度量具有经度和纬度两个field。一般情况下存放的是会随着时间戳的变化而变化的数据。

tag: 标签，或者附加信息。一般存放的是并不随着时间戳变化的属性信息。timestamp加上所有的tags可以认为是table的primary key。

如下图，度量为Wind，每一个数据点都具有一个timestamp，两个field：direction和speed，两个tag：sensor、city。它的第一行和第三行，存放的都是sensor号码为95D8-7913的设备，属性城市是上海。随着时间的变化，风向和风速都发生了改变，风向从23.4变成23.2;而风速从3.4变成了3.3。

![](http://img3.donews.com/uploads/img3/img_pic_1494301251_1.png)

gauge.*：HTTP请求的性能指标之一，它主要用来反映一个绝对数值。比如上面示例中的gauge.response.hello: 5，它表示上一次hello请求的延迟时间为5毫秒。
counter.*：HTTP请求的性能指标之一，它主要作为计数器来使用，记录了增加量和减少量。如上示例中counter.status.200.hello: 11，它代表了hello请求返回200状态的次数为11。
对于gauge.*和counter.*的统计，这里有一个特殊的内容请求star-star，它代表了对静态资源的访问。这两类度量指标非常有用，我们不仅可以使用它默认的统计指标，还可以在程序中轻松的增加自定义统计值。


## Prometheus
[Prometheus data model](https://prometheus.io/docs/concepts/data_model/)

timestamp metric labels
