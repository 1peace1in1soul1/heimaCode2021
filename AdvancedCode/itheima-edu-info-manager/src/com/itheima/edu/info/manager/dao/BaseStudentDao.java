package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Student;

import java.util.ArrayList;

public interface BaseStudentDao {

    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String delId);

    //根据id查找索引
    public abstract int getIndex(String id);

    public abstract void updateStudent(String updateId, Student newstu);
}
