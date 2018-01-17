package com.bao.msmetrics.controller;

import com.alibaba.fastjson.JSON;
import com.bao.msmetrics.model.TestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by baochunyu on 2018/1/11.
 */
@RestController
@Slf4j
public class MyController {
//    @Autowired
//    HttpServletRequest servletRequest;
    @PostMapping("/v1/test")
    public void test(HttpServletRequest servletRequest) throws IOException {
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
    }
}
