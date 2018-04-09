package com.bao.msmetrics.guava.joinable;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by nannan on 2018/3/15.
 */
public class Joinable {

    public static void main(String args[]) {
        Joiner joiner = Joiner.on("; ").skipNulls();
        joiner.join("Harry", null, "Ron", "Hermione");
        Joiner.on(",").join(Arrays.asList(1, 5, 7));


        //String.split悄悄丢弃了尾部的分隔符
        String[] arr = ",a,,b,".split(",");
        for (String a : arr) {
            System.out.println(" : " + a);
        }

        Splitter.on(',').trimResults().omitEmptyStrings().split(",a,,b,").forEach(node -> System.out.println(":" + node));
        Splitter.on(',').trimResults().split(",a,,b,").forEach(node -> System.out.println(":" + node));

        String string = "12312312dfsf";
        String noControl = CharMatcher.javaIsoControl().removeFrom(string); //移除control字符
        String theDigits = CharMatcher.digit().retainFrom(string); //只保留数字字符
        String spaced = CharMatcher.whitespace().trimAndCollapseFrom(string, ' ');//去除两端的空格，并把中间的连续空格替换成单个空格
        String noDigits = CharMatcher.javaDigit().replaceFrom(string, "*"); //用*号替换所有数字
        String lowerAndDigit = CharMatcher.javaDigit().or(CharMatcher.javaLowerCase()).retainFrom(string);// 只保留数字和小写字母


        Range.closed(1, 3).contains(2);//return true

        //Read the lines of a UTF-8 text file

        File file = new File("d:/logs/logs.txt");
        try {
            ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
