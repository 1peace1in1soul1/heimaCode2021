package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

public class StudentDao implements BaseStudentDao{
    // 1、创建一个学生对象的数组
    private static Student[] stus = new Student[5];
    static {
        Student stu1 = new Student("heima001","张三","23","1999-01-01");
        Student stu2 = new Student("heima002","李四","24","2000-01-01");
        stus[0] = stu1;
        stus[1] = stu2;
    }
    public boolean addStudent(Student stu) {

        // 2、添加学生到数组
            //思路:将对象存入到数组中null元素对应的索引位置
        //2.1 创建一个对应的变量index=-1，假设数组全满，没有null的元素
        int index = -1;
        //2.2 遍历数组中的每一个值，看是否是null
        for (int i = 0; i < stus.length; i++) {
            if(stus[i] == null){
                //2.3 如果值为null，让index记录当前索引值，并使用break结束循环遍历
                index = i;
                break;
            }
        }
        // 3、返回是否添加成功的boolean类型状态
        if (index == -1){
            //装满了
            return false;
        }else {
            //没有装满，正常添加，返回true
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        //1、查找id在容器中的索引位置
        int index = getIndex(delId);
        //2、将该索引位置的值，使用null元素进行覆盖
        stus[index] = null;
    }

    //根据id查找索引
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Student newstu) {
        //1、查找updateId，在容器中的索引位置
        int index = getIndex(updateId);
        //2、将该索引位置，使用新的学生对象进行替换
        stus[index] = newstu;
    }
}
