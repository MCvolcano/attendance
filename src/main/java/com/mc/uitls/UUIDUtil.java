package com.mc.uitls;

import java.util.UUID;

/**
 * Created by Administrator on 2017/11/28.
 */
public class UUIDUtil {
    public static String createID(){
        String s = UUID.randomUUID().toString();
        String s1 = s.replaceAll("-", "");
        return  s1;
    }

    public static void main(String[] args) {
        System.out.println(createID());
    }
}
