package com.pandawork.test;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by qiulan on 2016/4/3.
 */
public class StudentServiceTest extends AbstractTestCase{
    @Autowired
    StudentService studentService;

    @Test
    public void testListALL() throws SSException{
        List<Student> list = studentService.listAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
    @Test
    public void testDeleteById() throws SSException{
       studentService.deleteById(1);
    }
    @Test
    public void testInsert() throws SSException{
        Student student1 = new Student();
        student1.setStudentNum(1234);
        student1.setStudentName("qqqqq");
        student1.setSex(1);
        student1.setGrade(3);
        student1.setClassNum(2);
        student1.setCollege(5);
        student1.setBirthday(new Date(1995 - 10 - 05));
        student1.setGoodStudent(1);
        studentService.insert(student1);
    }
    @Test
    public void testUpdate() throws SSException{
        Student std = studentService.queryById(1);
        System.out.println(std);
        std.setStudentNum(111);
        std.setStudentName("nihaqqqo");
        std.setSex(1);
        std.setGrade(3);
        studentService.update(std);
    }

}
