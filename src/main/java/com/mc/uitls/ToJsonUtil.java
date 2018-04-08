package com.mc.uitls;

import com.mc.entity.Res;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ToJsonUtil {

    /*
    {
    "rows":[
      {
        "id":1,
        "text":"系统管理"
      },
      {
        "id":2,
        "text":"用户管理",
        "_parentId":1
      }
      ]
    }

    */

    public static String toJson(List<Res> data) {

        String s = "{\"rows\":[";
        for (Res r : data) {
            s += "{";
            s += "\"id\":" + r.getId() + ",";
            s += "\"text\":\"" + r.getText() + "\",";
            s += "\"url\":\"" + r.getUrl() + "\"";
            if (r.get_parentId() != 0) {
                s += ",\"_parentId\":" + r.get_parentId() + "},";
            } else {
                s += "},";
            }
        }

        s = s.substring(0, s.length()-1);
        s += "]}";
        System.out.println(s);

        return s;
    }

    public static void main(String[] args) throws IOException {
        //test1("D://1.txt");

        int c = 2;
        switch (c) {
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println("default");
        }
    }

    public static void test1(String filename) throws IOException {
        int countE = 0;
        int countB = 0;
        String c = "";
        String s = "";
        /*
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        int len = 0;
        byte[] r = new byte[1024];
        String z = "";
        while ((len = fileInputStream.read(r)) != -1) {
            z += new String(r,0,len);
        }
        System.out.println(z);
        */

        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));

        BufferedReader bf = new BufferedReader(isr);
        while((c = bf.readLine()) != null) {
            s += c;
        }

        for (byte b : s.getBytes()) {
            if (b >= 'A' && b <= 'Z') {
                countB++;
            }
            if((b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z')) {
                countE++;
            }
        }
        System.out.println("大写英文字符的个数为：" + countB);
        System.out.println("英文字符的总个数为：" + countE);
        bf.close();
        isr.close();
    }


}
