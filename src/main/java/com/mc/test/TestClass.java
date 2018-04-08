package com.mc.test;

import com.mc.entity.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Author：马灿
 * @Description:
 * @Date: 下午 6:13 2018-03-01
 */
public class TestClass {
    public static void main(String[] args) {


    }

    public static void addTeacher(){
        List<Teacher> list = new ArrayList<>();
        Teacher a = new Teacher();
        for (int i = 0; i <10; i++) {
            a.setId(UUID.randomUUID().toString());
            a.setName("教师" + i);
            a.setAge(20 + i);
            a.setPhone("1726666888" + i);
            a.setEmail("231441231@qq.com");
            a.setQq("231441231");
        }
    }




}
