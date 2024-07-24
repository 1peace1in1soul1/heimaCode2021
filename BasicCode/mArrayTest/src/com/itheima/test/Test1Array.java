package com.itheima.test;

public class Test1Array {
    /*
        数组的遍历：通过循环获取数组中的所有元素

        动态获取数组元素个数：数组名 . length
     */
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};

        //数组名 . length
        System.out.println("arr数组中元素的个数为:" + arr.length);
//        for (int i = 0 ; i < 5; i++){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
