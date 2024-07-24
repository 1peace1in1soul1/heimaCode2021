package com.itheima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1Static {
    /*
        1. 被static修饰的成员, 会被该类的所有对象所[共享]
        2. 被static修饰的成员, 会随着类的加载而加载, 优先于对象存在
        3. 多了一种调用方式, 可以通过类名.进行调用
        */
    public static void main(String[] args) {
        Student.school = "传智专修学院";
        Student stu1 = new Student();
        stu1.name = "张三";
        stu1.age = 23;
        //stu1.school = "传智专修学院";
        stu1.show();

        Student stu2 = new Student();
        stu2.show();
        System.out.println(generateNonRepeatingInteger());


    }
    public static int generateNonRepeatingInteger() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            digits.add(i);
        }

        Collections.shuffle(digits); // 打乱列表以获取不重复的数字

        // 从打乱后的列表中取出数字，组合成整数
        int nonRepeatingInteger = 0;
        int length = Math.min(4, digits.size()); // 您可以调整这里的数字个数
        for (int i = 0; i < length; i++) {
            nonRepeatingInteger = nonRepeatingInteger * 10 + digits.get(i);
        }
        return nonRepeatingInteger;
    }
}
