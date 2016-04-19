package com.pandawork.web.controller;

import com.pandawork.common.entity.Student;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.web.spring.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

/**
 * Created by qiulan on 2016/4/6.
 */
@Controller
@RequestMapping(value = "/Student")
public class StudentController extends AbstractController {
    /**
     * 显示学生列表
     * @param model
     * @return
     */
    @RequestMapping(value="list")
    public String ShowMessage(Model model){
        List<Student> list = null;
        try {
            list = studentService.listAll();
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
            return "ShowMessage";
    }

    @RequestMapping(value ="NewStudent",method =RequestMethod.GET)
    public String toNewStudent(){
        return "NewStudent";
    }

    @RequestMapping(value = "/UpdateStudent/{id}" ,method = RequestMethod.GET)
    public String toUpdateStudent(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("id", id);
        return "UpdateStudent";
    }

    /**
     * 删除学生
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "delete/{id}",method =RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") int id,Model model){
        try{
            studentService.deleteById(id);
            if(!studentService.deleteById(id)){
                model.addAttribute("message","操作失败");
            }
            return  "redirect:/Student/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 插入学生
     * @param student
     * @return
     */
    @RequestMapping(value = "insert")
    public String insertStudent(Student student){
        if(!Assert.isNotNull(student)){
            return null;
        }
        try {
            studentService.insert(student);
            return "redirect:/Student/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    /**
     * 更新学生信息
     * @param id
     * @param student
     * @return
     * @throws SSException
     */
    @RequestMapping(value="update/{id}", method = RequestMethod.POST)
     public String updateStudent(@PathVariable("id") int id,
                                 @PathVariable("studentNum") int studentNum,
                                 @PathVariable("studentName") String studentName,
                                 @PathVariable("sex") int sex,
                                 @PathVariable("grade") int grade,
                                 @PathVariable("classNum") int classNum,
                                 @PathVariable("college") int college,
                                 @PathVariable("birthday") Date birthday,
                                 @PathVariable("goodStudent") int goodStudent,
                                 Student student) throws SSException {
        if(!Assert.isNotNull(student)){
            return null ;
        }

        try {
            student.setStudentNum(studentNum);
            student.setStudentName(studentName);
            student.setSex(sex);
            student.setGrade(grade);
            student.setClassNum(classNum);
            student.setCollege(college);
            student.setBirthday(birthday);
            student.setGoodStudent(goodStudent);
            studentService.update(student);
            return "redirect:/Student/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
//    @RequestMapping(value = "query/${id}")
//    public String queryById(@PathVariable("id") int id, Model model)throws SSException{
//        if(Assert.lessOrEqualZero(id)){
//            return null;
//        }
//        Student student = null;
//        try {
//            student=studentService.queryById(id);
//            model.addAttribute("stdList",student);
//
//        }catch (Exception e){
//            LogClerk.errLog.error(e);
//            sendErrMsg(e.getMessage());
//            return ADMIN_SYS_ERR_PAGE;
//        }
//        return "UpdateStudent";
//    }
}
