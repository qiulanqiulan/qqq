package com.pandawork.service.impl;

import com.pandawork.common.entity.Student;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.mapper.StudentMapper;
import com.pandawork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * student service实现
 * Created by qiulan on 2016/3/31.
 */
@Service("studentService")
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentMapper studentmapper;

    /**
     * 根据id进行查询
     * @param id
     * @return
     * @throws SSException
     */
    @Override
    public Student queryById(int id) throws SSException {
        if(Assert.lessOrEqualZero(id)){  //id为0或者为负数
            return null;
        }
        try{
            return studentmapper.queryById(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 更新信息
     * @param student
     * @throws SSException
     */
    @Override
    public void update(Student student) throws SSException{
        if(!Assert.isNotNull(student)){
            return ;
        }
        try{
            studentmapper.update(student);
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 根据id进行删除
     * @param id
     * @throws SSException
     */
    @Override
    public boolean deleteById(int id) throws SSException{
        if(Assert.lessOrEqualZero(id)){
            return false;
        }
        try{
            studentmapper.deleteById(id);
            return true;
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 显示学生列表
     * @return
     * @throws SSException
     */
    @Override
    public List<Student> listAll() throws  SSException{
        try {
            return studentmapper.listAll();
        }catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    /**
     * 插入学生信息
     * @param student
     * @throws Exception
     */
    @Override
    public void insert(Student student) throws SSException{
        if(!Assert.isNotNull(student)){
            return;
        }
        try{
            studentmapper.insert(student);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }
}
