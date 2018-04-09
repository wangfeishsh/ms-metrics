package com.bao.msmetrics.guava.math;

import java.util.Base64;

/**
 * Created by nannan on 2018/3/15.
 */
public class Mathable {
    /*
    IntMath、LongMath和BigIntegerMath提供了很多实数运算的方法，并把最终运算结果舍入成整数。这些方法接受一个java.math.RoundingMode枚举值作为舍入的模式：

    DOWN：向零方向舍入（去尾法）
    UP：远离零方向舍入
    FLOOR：向负无限大方向舍入
    CEILING：向正无限大方向舍入
    UNNECESSARY：不需要舍入，如果用此模式进行舍入，应直接抛出ArithmeticException
    HALF_UP：向最近的整数舍入，其中x.5远离零方向舍入
    HALF_DOWN：向最近的整数舍入，其中x.5向零方向舍入
    HALF_EVEN：向最近的整数舍入，其中x.5向相邻的偶数舍入
    */

    public static void main(String args[]){

        byte[] bytes= Base64.getDecoder().decode("T05FUExVUyBBNTAxMA==");
        System.out.println(new String(bytes));
    }
}
