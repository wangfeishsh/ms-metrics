package com.bao.msmetrics.controller;

import com.bao.msmetrics.constant.MyConstant;
import com.bao.msmetrics.listener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by baochunyu on 2018/1/11.
 */
@RestController
@Slf4j
public class MyController {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    SystemPublicMetrics systemPublicMetrics;

    @GetMapping("/listen")
    public String listen(){
        MyEvent myEvent = new MyEvent(this);
        myEvent.setName("dd");
        applicationContext.publishEvent(myEvent);
        return ";";
    }

    @PostMapping("/v1/metric")
    public void metric(){
//        if(MyConstant.rateLimiter.tryAcquire()){
//            System.out.println("this");
//        }else {
//            System.out.println("that");
//        }
        executorService.execute(()->ddd());

    }

    private void ddd(){
        System.out.println("adfs");
    }

    //    @Autowired
//    HttpServletRequest servletRequest;
    @PostMapping("/v1/test")
    public String test(HttpServletRequest servletRequest) throws IOException {


        systemPublicMetrics.metrics().stream().forEach(node -> {
            System.out.println(node.getName() + ":" + node.getValue());
        });
//        log.info(JSON.toJSONString(testModel));
        ServletInputStream ris = servletRequest.getInputStream();
        StringBuilder content = new StringBuilder();
        byte[] b = new byte[1024];
        int lens = -1;
        while ((lens = ris.read(b)) > 0) {
            content.append(new String(b, 0, lens));
        }
        String strcont = content.toString();// 内容
        System.out.println(strcont);
        return strcont;
    }
}
