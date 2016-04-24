package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 学生实体类
 * Created by qiulan on 2016/3/31.
 */
@Table(name="t_student")
@Entity
public class Student extends AbstractEntity {
    @Id
    private Integer id;

    //学生学号
    @Column(name="student_num")
    private Integer studentNum;

    //学生姓名
    @Column(name = "name")
    private String studentName;

    //学生性别
    @Column(name = "sex")
    private Integer sex;

    //学生年级
    @Column(name="grade")
    private Integer grade;

    //学生班级
    @Column(name="class_num")
    private Integer classNum;

    //学生学院代码
    @Column(name="college")
    private Integer college;

    //学生生日
    @Column(name="birthday")
    private Date birthday;

    //学生是否为好学生
    @Column(name="is_good_student")
    private Integer goodStudent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Integer getCollege() {
        return college;
    }

    public void setCollege(Integer college) {
        this.college = college;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getGoodStudent() {
        return goodStudent;
    }

    public void setGoodStudent(Integer goodStudent) {
        this.goodStudent = goodStudent;
    }

    @Override
    public void setId(Integer integer) {
    }
}
