package com.bao.msmetrics.util;

import com.bao.msmetrics.model.User;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by baochunyu on 2018/1/18.
 */
public class JmxDemo {
    public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException,
            MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {

        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("jmxdemo:type=User");
        User user = new User();
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
