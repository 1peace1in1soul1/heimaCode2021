package com.itheima.edu.info.manager.service;

import com.itheima.edu.info.manager.dao.TeacherDao;
import com.itheima.edu.info.manager.domain.Teacher;

public class TeacherService {

    private TeacherDao teacherDao = new TeacherDao();
    public boolean addTeacher(Teacher t) {
        return teacherDao.addTeacher(t);
    }

    public boolean isExists(String id) {
        //1、获取库管对象中的数组
        Teacher[] teachers =  teacherDao.findAllTeachers();
        boolean exists = false;
        //2、遍历数组，取出每一个数组，进行判断
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if (teacher != null && teacher.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] allTeachers = teacherDao.findAllTeachers();
        boolean flag = false;
         for (int i = 0; i < allTeachers.length; i++) {
            Teacher t = allTeachers[i];
            if (t != null){
                flag = true;
                break;
            }
        }
        if (flag){
            return allTeachers;
        }else{
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }


    public void updateTeacher(String id, Teacher newteacher) {
        teacherDao.updateTeacher(id,newteacher);
    }
}
