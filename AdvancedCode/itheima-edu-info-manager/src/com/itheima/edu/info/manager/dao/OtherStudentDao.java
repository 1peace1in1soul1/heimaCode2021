package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentDao{
    // 1、创建一个学生对象的数组
    private static ArrayList<Student> stus = new ArrayList<>();
    static {
        Student stu1 = new Student("heima001","张三","23","1999-01-01");
        Student stu2 = new Student("heima002","李四","24","2000-01-01");
        stus.add(stu1) ;
        stus.add(stu2) ;
    }
    public boolean addStudent(Student stu) {
        stus.add(stu);
        return true;
    }

    public Student[] findAllStudent() {
        Student[] students = new Student[stus.size()];
        for (int i = 0; i < students.length; i++) {
            students[i] = stus.get(i);

        }
        return students;
    }

    public void deleteStudentById(String delId) {
        //1、查找id在容器中的索引位置
        int index = getIndex(delId);
        stus.remove(index);
    }

    //根据id查找索引
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
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
        stus.set(index,newstu);
    }
}
