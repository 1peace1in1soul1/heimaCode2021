package com.heima.test;

import java.util.ArrayList;

public class Test4 {
    /*
    需求：创建一个存储String的集合
    内部存储（test，张三，李四，test，test）字符串
    删除所有的test字符串，删除后，将集合剩余元素打印在控制台

    思路：
    1. 创建集合对象
    2. 调用add方法，添加字符串
    3. 遍历集合，取出每一个字符串元素
    4. 加入if判断，如果是test字符串，调用remove方法删除
    5. 打印集合元素

   // 注意: 根据元素进行删除, 只能删除集合中的第一个元素
    list.remove("test");
 */
    public static void main(String[] args) {
        // 1. 创建集合对象
        ArrayList<String> list = new ArrayList<>();
        // 2. 调用add方法，添加字符串
        list.add("test");
        list.add("张三");
        list.add("李四");
        list.add("test");
        list.add("test");
        // 3. 遍历集合，取出每一个字符串元素
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            // 4. 加入if判断，如果是test字符串，调用remove方法删除
            //if(s.equals("test")){}
            if("test".equals(s)){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}
