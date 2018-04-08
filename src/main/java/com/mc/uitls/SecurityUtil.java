package com.mc.uitls;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    //md5加密
    public static String encrypt(String src) {
        try {
            //创建消息照耀实例对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] a = md5.digest(src.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < a.length; i++) {
                //进行位运算
                int x = (int)a[i]&0xff;
                //加盐值
                x = x + 1;
                if (x < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(x));
            }
            System.out.println(sb);
//            System.out.println("--" + a);
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        encrypt("abc");
    }


}
