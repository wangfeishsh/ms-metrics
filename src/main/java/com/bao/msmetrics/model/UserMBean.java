package com.bao.msmetrics.model;

/**
 * Created by baochunyu on 2018/1/18.
 */
public interface UserMBean {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    int add(int x,int y);
}
