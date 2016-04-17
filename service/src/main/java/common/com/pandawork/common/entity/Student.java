package com.pandawork.common.entity;

import com.pandawork.core.common.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by qiulan on 2016/3/31.
 */
@Table(name="t_student")
@Entity
public  class Student extends AbstractEntity {
    @Id
    private int id;

    @Column(name="student_num")
    private int studentNum;

    @Column(name = "name")
    private String studentName;

    @Column(name = "sex")
    private int sex;

    @Column(name="grade")
    private int grade;

    @Column(name="class_num")
    private int classNum;

    @Column(name="college")
    private int college;

    @Column(name="birthday")
    private Date birthday;

    @Column(name="is_good_student")
    private int goodStudent;

    public void setGoodStudent(int goodStudent) {
        this.goodStudent = goodStudent;
    }

    public int getGoodStudent() {return goodStudent;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getStudentNum() {return studentNum;}

    public void setStudentNum(int studentNum) {this.studentNum = studentNum;}

    public String getStudentName() {return studentName;}

    public void setStudentName(String studentName) {this.studentName = studentName;}

    public int getSex() {return sex;}

    public void setSex(int sex) {this.sex = sex;}

    public int getGrade() {return grade;}

    public void setGrade(int grade) {this.grade = grade;}

    public int getClassNum() {return classNum;}

    public void setClassNum(int classNum) {this.classNum = classNum;}

    public int getCollege() {return college;}

    public void setCollege(int college) {this.college = college;}

    public Date getBirthday() {return birthday;}

    public void setBirthday(Date birthday) {this.birthday = birthday;}

    @Override
    public void setId(Integer integer) {}
}
