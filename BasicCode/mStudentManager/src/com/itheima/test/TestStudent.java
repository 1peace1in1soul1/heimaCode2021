package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;

public class TestStudent {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("heima001","张三",23,"1999-11-11");
        Student stu2 = new Student("heima002","李四",24,"1999-12-12");
        Student stu3 = new Student("heima003","王五",25,"1999-1-1");
        list.add(stu1);
        list.add(stu2);
        list.add(stu2);

        int index1 = getIndex(list,"heima001");
        int index2 = getIndex(list, "heima009");

        System.out.println(index1);  // 0
        System.out.println(index2);  // -1

    }

    public static int getIndex(ArrayList<Student> list, String sid){
        // 1. 假设传入的学号, 在集合中不存在
        int index = -1;
        // 2. 遍历集合, 获取每一个学生对象, 准备进行查找
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            // 3. 获取每一个学生对象的学号
            String id = stu.getSid();
            // 4. 使用获取出的学生学号, 和传入的学号(查找的学号)进行比对
            if(id.equals(sid)){
                // 存在: 让index变量记录正确的索引位置
                index = i;
            }
        }

        return index;
    }
}
