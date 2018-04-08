package com.mc.uitls;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/11/28.
 */
public class ThreadUtil {
   public static ExecutorService pool;
    static {
         pool = Executors.newFixedThreadPool(5);
    };
}
