package com.pandawork.service;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import java.util.List;

/**
 * student service 层
 * Created by qiulan on 2016/3/31.
 */
public interface StudentService {
   
    /**
     * 根据id查学生
     * @param id
     * @return
     * @throws SSException
     */
    public Student queryById(int id)throws SSException;

    /**
     * 更新
     * @param student
     * @throws SSException
     */
    public void update(Student student)throws SSException;

    /**
     * 删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean deleteById(int id)throws SSException;

    /**
     * 获取学生列表
     * @return
     * @throws SSException
     */
    public List<Student> listAll() throws SSException;

    /**
     * 插入
     * @param student
     * @throws SSException
     */
    public void insert(Student student)throws SSException;
}
