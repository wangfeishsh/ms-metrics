package com.bao.msmetrics.guava.nullable;


import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by nannan on 2018/3/14.
 */
public class Nullable {
    public static void main(String args[]) {
//        Optional<Integer> optional = Optional.of(null);
//        Optional<Integer> optional = Optional.fromNullable(null);
//        Optional<Integer> optional = Optional.absent();
//        System.out.println(optional.get());

//        checkArgument(Boolean.FALSE);

        Date date = new Date(1521011215480L);
        System.out.println(System.currentTimeMillis());
        System.out.println(1521011215480L);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(date));

        Objects.equals("null", "a");

        Ordering<Integer> ordering = Ordering.natural();
        System.out.println(ordering.min(1, 2));

        ImmutableSet<String> immutableSet = ImmutableSet.of("1", "2", "3");

        List<String> list = Lists.newArrayList("11", "22");

        Set<String> animals = ImmutableSet.of("gerbil", "hamster");
        Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");

        Set<String> stringSet = new HashSet<>();
        Sets.difference(animals,fruits).copyInto(stringSet);
        System.out.println(stringSet.size());

        Lists.partition(list,2).forEach(node-> System.out.println(node.size()));

    }
}
