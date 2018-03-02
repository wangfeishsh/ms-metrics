package com.bao.msmetrics.util;

import com.bao.msmetrics.model.User;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by baochunyu on 2018/1/18.
 */
public class JmxDemo {
    public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException,
            MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {

        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("jmxdemo:type=User");
        List<String> list= new ArrayList<>();
        for(int i =0; i<100000;i++){
            list.add(UUID.randomUUID().toString());
        }
        User user = new User();
        user.setList(list);
        beanServer.registerMBean(user, objectName);
        String oldusername = null;
        String oldpassword = null;
        while (true) {
            if (oldusername != user.getUsername() || oldpassword != user.getPassword()) {
                System.out.println(user.getUsername() + "," + user.getPassword());
                oldusername = user.getUsername();
                oldpassword = user.getPassword();
            }
            Thread.sleep(1000);
        }
    }
}
