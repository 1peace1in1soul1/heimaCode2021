package com.itheima.edu.info.manager.dao;

import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherDao {

    public static Teacher[] teachers  = new Teacher[5];

    public boolean addTeacher(Teacher t) {
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher == null) {
                index = i;
                break;
            }
        }
        if (index == -1){
            return false;
        }else{
            teachers[index] = t;
            return true;
        }
    }

    public Teacher[] findAllTeachers() {
        return teachers;
    }

    public void deleteTeacherById(String id) {
        //1、查询id在数组中索引位置
        int index = getIndex(id);
        //2、将该索引位置上的元素值，重置为null（用null进行替换）
        teachers[index] = null;
    }
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null && t.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String id, Teacher newteacher) {
        //1、查询id在数组中索引位置
        int index = getIndex(id);
        //2、将该索引位置上的元素值，实用新对象进行替换
        teachers[index] = newteacher;
    }
}
