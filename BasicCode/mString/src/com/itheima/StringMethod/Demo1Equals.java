package com.itheima.StringMethod;

public class Demo1Equals {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ABC";
        String s3 = "abc";
        // equals : 比较字符串内容, 区分大小写
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        // equalsIgnoreCase : 比较字符串内容, 忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));

    }

}
