package com.heima.test;

import com.heima.domain.Student;

import java.util.ArrayList;

public class Test5 {
    public static void main(String[] args) {
        // 7. main方法中测试该方法
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三1",10);
        Student stu2 = new Student("张三2",10);
        Student stu3 = new Student("张三3",20);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        ArrayList<Student> newList = getList(list);
        for (int i = 0; i < newList.size(); i++) {
            Student stu = newList.get(i);
            System.out.println(stu.getName() + "..." + stu.getAge());
        }
    }
    public static ArrayList<Student> getList(ArrayList<Student>list){
        ArrayList<Student> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getAge() < 18){
                newList.add(stu);
            }
        }
        return newList;
    }

}
