package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController extends BaseStudentController{

    private Scanner sc = new Scanner(System.in);

    //键盘录入学生信息
    //开闭原则：对扩展内容开放，对修改内容关闭
    @Override
    public Student inputStudentInfo(String id){
        System.out.println("请输入学生的姓名");
        String name = sc.next();
        System.out.println("请输入学生的年龄");
        String age = sc.next();
        System.out.println("请输入学生的生日");
        String birthday = sc.next();
        //2、将学生信息封装为学生对象
        Student stu = new Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}

