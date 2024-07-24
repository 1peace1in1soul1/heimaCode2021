package com.itheima.test;

import java.util.Scanner;

public class Test5Array {
    /*
        需求：在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100的整数分。
                选手的最后得分为：去掉一个最高分和一个最低分后 的4个评委平均值 (不考虑小数部分)。

        思路：
            1.定义一个数组，用动态初始化完成数组元素的初始化，长度为6
            2.键盘录入评委分数
            3.由于是6个评委打分，所以，接收评委分数的操作，用循环
            4.求出数组最大值
            5.求出数组最小值
            6.求出数组总和
            7.按照计算规则进行计算得到平均分
            8.输出平均分

     */
    public static void main(String[] args) {
        // 1.定义一个数组，用动态初始化完成数组元素的初始化，长度为6
        int[] arr = new int[6];
        // 2.键盘录入评委分数
        Scanner sc = new Scanner(System.in);
        //  3.由于是6个评委打分，所以，接收评委分数的操作，用循环
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i+1) + "个评委的打分:");
            int score = sc.nextInt();

            if(score >=0 && score <= 100){
                System.out.println("得分合法，分数为：" + score);
                // 合法的分值
                arr[i] = score;
            }else{
                System.out.println("输入不合法，请重新输入：");
                // 非法的分值
                i--;
            }
        }
        // 4.求出数组最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("最大值为：" + max);
        // 5.求出数组最小值
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("最小值为：" + min);
        // 6.求出数组总和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("总和为："+ sum);
        // 7.按照计算规则进行计算得到平均分
        int avg = (sum - max - min) / 4;
        System.out.println("平均分为："+ avg);

    }
}
