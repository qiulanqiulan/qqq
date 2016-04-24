package com.pandawork.mapper;

import com.pandawork.common.entity.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * student mapper层
 * Created by qiulan on 2016/3/31.
 */
public interface StudentMapper {

    /**
     * 根据id查询学生
     * @param id
     * @return
     * @throws Exception
     */
    public Student queryById(@Param("id")int id)throws Exception;

    /**
     * 更新
     * @param student
     * @throws Exception
     */
    public void update(@Param("student")Student student)throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteById(@Param("id")int id)throws Exception;

    /**
     * 获取学生列表
     * @return
     * @throws Exception
     */
    public List<Student> listAll()throws Exception;

    /**
     * 增加学生信息
     * @param student
     * @throws Exception
     */
    public void insert(@Param("student")Student student) throws Exception;
}
