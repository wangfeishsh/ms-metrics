package com.bao.msmetrics.listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by nannan on 2018/3/8.
 */
public class MyEvent extends ApplicationEvent {

    private String name ;
    public MyEvent(Object source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
