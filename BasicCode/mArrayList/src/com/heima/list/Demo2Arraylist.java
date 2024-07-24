package com.heima.list;

import java.util.ArrayList;

public class Demo2Arraylist {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        // public E get(int index) 返回指定索引处的元素
        String s1 = list.get(0);
        String s2 = list.get(1);
        String s3 = list.get(2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // public int size() 返回集合中的元素的个数
        int size = list.size();
        System.out.println(size);
    }

    private static void testSet() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        //  public E set(int index,E element) 修改指定索引处的元素，返回被修改的元素
        String s = list.set(0,"666");
        System.out.println(s);

        System.out.println(list);
    }

    private static void testRemove() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        //  public boolean remove(Object o) 删除指定的元素，返回删除是否成功
        boolean b1 = list.remove("abc");
        boolean b2 = list.remove("zzz");

        System.out.println(b1);
        System.out.println(b2);

        System.out.println(list);

        // public E remove(int index)  删除指定索引处的元素，返回被删除的元素
        String s = list.remove(0);
        System.out.println(s);

        System.out.println(list);
    }
}
