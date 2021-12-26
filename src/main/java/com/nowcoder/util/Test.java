package com.nowcoder.util;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class Test {
    private static int value;
    public static void main(String[] args) {
        final ThreadLocal<Integer> threadLocal = new ThreadLocal();
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        value = finalI;
                        threadLocal.set(value);
                        Thread.sleep(1000);
                        System.out.println(threadLocal.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
