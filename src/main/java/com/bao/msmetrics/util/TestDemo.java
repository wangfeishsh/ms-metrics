package com.bao.msmetrics.util;

import com.bao.msmetrics.model.TestModel;
import com.bao.msmetrics.model.User;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by baochunyu on 2018/1/18.
 */
public class TestDemo {

    public static Date covertLocalDate (LocalDate localDate) {
        return new Date(localDate.getYear() - 1900,localDate.getMonthValue() - 1,localDate.getDayOfMonth());
    }
    public static void main(String[] args){

        TestModel t = new TestModel();
        t.setId("111");

        System.out.println("dd".equals(t.getName()));

        List<TestModel> list = new ArrayList<>();
        list.add(null);

        System.out.println(list.size());



    }
}
