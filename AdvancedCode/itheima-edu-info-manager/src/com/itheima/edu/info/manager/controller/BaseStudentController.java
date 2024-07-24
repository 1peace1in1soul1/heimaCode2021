package com.itheima.edu.info.manager.controller;

import com.itheima.edu.info.manager.domain.Student;
import com.itheima.edu.info.manager.service.StudentService;

import java.util.Scanner;

public abstract class BaseStudentController {
    //业务员对象
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);
    //开启学生管理系统，展示学生管理系统菜单
    public final void start() {
//        Scanner sc = new Scanner(System.in);
        studentLoop:while (true){
            // 主菜单搭建
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.next();
            switch (choice){
                case "1":
//                    System.out.println("1.添加学生");
                    addStudent();
                    break;
                case "2":
//                    System.out.println("2.删除学生");
                    deleteStudentById();
                    break;
                case "3":
//                    System.out.println("3.修改学生");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("4.查看学生");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统, 再见!");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
    }
}
    //修改学生方法
    public final void updateStudent() {
        String updateId = inputStudentId();
//        while (true){
//            //1、键盘录入要修改的学生
//            System.out.println("请输入要修改的学生id：");
//            updateId = sc.next();
//            //2、判断id在容器中是否存在，若不存在则需要一直录入
//            boolean exists = studentService.isExists(updateId);
//            if(!exists){
//                System.out.println("您输入的id不存在，请重新输入");
//            }else {
//                break;
//            }
//        }

//        System.out.println("请输入学生姓名：");
//        String name = sc.next();
//        System.out.println("请输入学生年龄：");
//        String age = sc.next();
//        System.out.println("请输入学生生日：");
//        String birthday = sc.next();
//
//        Student newstu = new Student();
//        newstu.setId(updateId);
//        newstu.setName(name);
//        newstu.setAge(age);
//        newstu.setBirthday(birthday);
        Student newstu = inputStudentInfo(updateId);
        //3、调用业务员中的updateStudent方法，修改学生
        studentService.updateStudent(updateId, newstu);
        //4、返回删除学生成功
        System.out.println("修改成功");
    }
    //删除学生方法
    public final void deleteStudentById() {
        String delId = inputStudentId();
//        while (true){
//            //1、键盘录入要删除的学生
//            System.out.println("请输入要删除的学生id：");
//            delId = sc.next();
//            //2、判断id在容器中是否存在，若不存在则需要一直录入
//            boolean exists = studentService.isExists(delId);
//            if(!exists){
//                System.out.println("您输入的id不存在，请重新输入");
//            }else {
//                break;
//            }
//        }

        //3、调用业务员中的deleteStudentById方法，删除学生
        studentService.deleteStudentById(delId);
        //4、返回删除学生成功
        System.out.println("删除成功");
    }
    //查看学生方法
    public final void findAllStudent() {
        // 1、调用业务员中的findAllStudent方法，得到学生的对象数组
        Student[] stus = studentService.findAllStudent();
        // 2、判断数组的内存地址是否为null
        if (stus == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        // 3. 遍历数组, 获取学生信息并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null){
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }
    //添加学生方法
    public final void addStudent() {
//        StudentService studentService = new StudentService();
        // 1. 键盘接收学生信息
        Scanner sc = new Scanner(System.in);
        String id;
        while (true){
            System.out.println("请输入学生的id");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (flag){
                System.out.println("学号已被占用，请重新输入");
            }else{
                break;
            }
        }
//        System.out.println("请输入学生的姓名");
//        String name = sc.next();
//        System.out.println("请输入学生的年龄");
//        String age = sc.next();
//        System.out.println("请输入学生的生日");
//        String birthday = sc.next();
//        //2、将学生信息封装为学生对象
//        Student stu = new Student();
//        stu.setId(id);
//        stu.setName(name);
//        stu.setAge(age);
//        stu.setBirthday(birthday);
        Student stu = inputStudentInfo(id);
        //3、将学生对象传递给StudentService(业务员)的addStudent方法
        boolean result = studentService.addStudent(stu);
        //4、将返回的boolean值返回成打印失败或者成功
        if (result) {
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
    //键盘录入学生id
    public String inputStudentId() {
        String Id;
        while (true) {
            System.out.println("请输入学生id：");
            Id = sc.next();
            //2、判断id在容器中是否存在，若不存在则需要一直录入
            boolean exists = studentService.isExists(Id);
            if (!exists) {
                System.out.println("您输入的id不存在，请重新输入");
            } else {
                break;
            }
        }
        return Id;
    }

    //键盘录入学生信息
    //开闭原则：对扩展内容开放，对修改内容关闭
    public abstract Student inputStudentInfo(String id);
}

