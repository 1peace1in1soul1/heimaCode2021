package com.heima.list;

import java.util.ArrayList;

public class Demo1ArrayList {
     /*
        ArrayList构造方法:
                ArrayList() 构造一个初始容量为 10 的空列表。

        成员方法:
            添加:
                boolean add(E e) 将指定的元素添加到此列表的尾部。
                void add(int index, E element) 将指定的元素插入此列表中的指定位置。


        注意:
                集合容器如果没有加入<> 就可以存储任意数据类型

                <> 泛型: 对集合容器存储的数据类型进行限制
     */
     public static void main(String[] args) {
          ArrayList<String> list = new ArrayList<>();
          list.add("111");
          list.add("222");
          list.add("333");
          list.add("444");

          list.add(0,"555");
          list.add(5,"555");

          System.out.println(list);
          
     }
}
