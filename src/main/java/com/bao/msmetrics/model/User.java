package com.bao.msmetrics.model;

import java.util.List;

/**
 * Created by baochunyu on 2018/1/18.
 */
public class User implements UserMBean {
    private String username;
    private String password;
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public int add(int x, int y) {
        return x + y;
    }
}
