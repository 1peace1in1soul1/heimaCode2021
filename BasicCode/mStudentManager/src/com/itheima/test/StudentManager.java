package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();



        lo:while(true){

            // 1. 搭建主界面菜单
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");
            String choice = sc.next();
            switch (choice){
                case "1":
//                    System.out.println("添加学生");
                    addStudent(list);
                    break;

                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(list);
                    break;

                case "3":
                    //System.out.println("修改学生");
                    updateStudent(list);
                    break;

                case "4":
                    //System.out.println("查看学生");
                    queryStudent(list);
                    break;

                case "5":
                    System.out.println("退出");
                    break lo;
                default:
                    System.out.println("您的输入有误");
                    break;
            }
        }

    }

    //修改学生的方法
    public static void updateStudent(ArrayList<Student> list) {
        //1、给出提示的信息（要修改的学号）
        System.out.println("请输入您要修改的学生学号:");
        //2、键盘接收要修改的学号
        Scanner sc = new Scanner(System.in);
        String updateSid = sc.next();
        //3、调用getIndex方法，查找出该学号在集合中的索引位置
        int index = getIndex(list, updateSid);
        //4、根据索引判断该学号是否存在
        if (index == -1){
            //不存在，给出提示
            System.out.println("查无信息, 请重新输入");
        }else{
            //存在：接收新的学生信息对象
            System.out.println("修改后的学生姓名为：");
            String name = sc.next();
            System.out.println("修改后的学生年龄为：");
            int age = sc.nextInt();
            System.out.println("修改后的学生生日为：");
            String birthday = sc.next();
            //封装为新的学生对象
            Student stu = new Student(updateSid,name,age,birthday);
            //调用集合的set方法，完成修改
            list.set(index,stu);
            System.out.println("修改成功！");
        }
    }

    //删除学生的方法
    public static void deleteStudent(ArrayList<Student> list) {
        //1、给出提示的信息（要删除的学号）
        System.out.println("请输入您要删除的学生学号:");
        //2、键盘接收要删除的学号
        Scanner sc = new Scanner(System.in);
        String deleteSid = sc.next();
        //3、调用getIndex方法，查找出该学号在集合中的索引位置
        int index = getIndex(list, deleteSid);
        //4、根据索引判断该学号是否存在
        if (index == -1){
            //不存在，给出提示
            System.out.println("查无信息, 请重新输入");
        }else{
            //存在：删除
            list.remove(index);
            System.out.println("删除成功!");
        }

    }

    //查看学生的方法
    public static void queryStudent(ArrayList<Student> list) {
        //1、判断集合中是否存在数据，如果不存在直接给出提示
        if(list.size() == 0){
            System.out.println("无信息, 请添加后重新查询");
            return;
        }
        //2、若存在：展示表头数据
        System.out.println("学号\t姓名\t年龄\t生日");
        //3、遍历集合，打印每一个学生对象的信息，打印在控制台
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println( stu.getSid() + "\t" + stu.getName() + "\t" + stu.getAge() + "岁" + "\t" + stu.getBirthday() );
        }
    }

    //添加学生的方法
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String sid;
        // 1. 给出录入的提示信息
        while (true){
            System.out.println("请输入学生的学号：");
            sid = sc.next();
            int index = getIndex(list, sid);
            if (index == -1){
                // sid不存在, 学号可以使用
                break;
            }else{
                System.out.println("学号已存在，请不要重复输入");
            }

        }

        System.out.println("请输入学生的姓名：");
        String name = sc.next();
        System.out.println("请输入学生的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入学生的生日：");
        String birthday = sc.next();
        // 2. 将键盘录入的信息封装为学生对象
        Student stu = new Student(sid, name, age, birthday);

        // 3. 将封装好的学生对象, 添加到集合容器当中
        list.add(stu);
        // 4. 给出添加成功的提示信息
        System.out.println("添加学生成功");

    }

/*
    接收一个集合对象，接收一个学生学号
    查找这个学号，在这个集合中的索引位置
*/
    public static int getIndex(ArrayList<Student> list, String sid){
        //1、假设传入的序号在集合中不存在
        int index = -1;
        //2、存在：遍历集合，查找所有学生对象的学号，准备进行查找
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            //3、获取每一个学生对象的学号
            String id = stu.getSid();
            //4、使用获取出的学号和传入的（查找的）学号进行比较
            if (id.equals(sid)){
                //存在，就让变量index记录正确的索引位置
                index = i;
            }
        }
        return index;


    }
}
