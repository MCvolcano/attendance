package com.mc.test;

import java.util.Arrays;

/**
 * @Author：马灿
 * @Description:
 * @Date: 下午 6:13 2018-03-01
 */
public class TestClass {
    public static void main(String[] args) {
        int[] arr = {2,1,6,3,5,4,9,7,8};
//        Arrays.sort(arr);
        TestClass t = new TestClass();
        System.out.println(Arrays.toString(arr));
        t.selectSort(arr);
        System.out.println("选择排序 " + Arrays.toString(arr));
        t.bubbleSort(arr);
        System.out.println("冒泡排序 " + Arrays.toString(arr));
    }

    //选择排序
    public void selectSort(int[] arr) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] < arr[j]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
    //快速排序


    //冒泡排序
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }



}
