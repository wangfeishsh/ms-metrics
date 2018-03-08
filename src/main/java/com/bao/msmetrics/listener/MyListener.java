package com.bao.msmetrics.listener;

import org.springframework.context.ApplicationListener;

/**
 * Created by nannan on 2018/3/8.
 */
public class MyListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println(myEvent.getName());
    }
}
