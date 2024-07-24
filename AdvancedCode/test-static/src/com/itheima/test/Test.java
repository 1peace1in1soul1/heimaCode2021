package com.itheima.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 创建一个 List
        List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Orange");
        myList.add("Banana");
        myList.add("Mango");

        // 创建一个 Random 对象
        Random random = new Random();

        // 生成一个随机索引
        int randomIndex = random.nextInt(myList.size());

        // 从 List 中获取随机元素
        String randomElement = myList.get(randomIndex);

        // 输出随机元素
        System.out.println("随机元素为: " + randomElement);
    }
}


