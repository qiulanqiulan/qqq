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

import java.util.Collections;
import java.util.List;

/**
 * student controller层
 * Created by qiulan on 2016/4/6.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController extends AbstractController {
    /**
     * 显示学生列表
     * @param model
     * @return
     */
    @RequestMapping(value = "list")
    public String ShowMessage(Model model){
        List<Student> list = Collections.emptyList();
        try {
            list = studentService.listAll();
            model.addAttribute("list", list);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
            return "ShowMessage";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String toNew(){
        return "NewStudent";
    }

    @RequestMapping(value = "query", method = RequestMethod.GET)
    public String toQuery(){ return "QueryStudent"; }

    @RequestMapping(value = "change/{id}", method = RequestMethod.GET)
    public String toChange(@PathVariable("id")int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("id", id);
        return "UpdateStudent";
    }

    /**
     * 删除学生
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") int id){
        try{
            studentService.deleteById(id);
            return  "redirect:/student/list";
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
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insertStudent(Student student){
        if(!Assert.isNotNull(student)){
            return null;
        }
        try {
            studentService.insert(student);
            return "redirect:/student/list";
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
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
     public String updateStudent(@PathVariable("id") int id, Student student) throws SSException {
        if (!Assert.isNotNull(student)) {
            return null ;
        }
        try {
            studentService.update(student);
            return "redirect:/student/list";
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public String queryById(@PathVariable("id") int id, Model model)throws SSException{
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try{
            Student student=studentService.queryById(id);
            model.addAttribute("stdList",student);
            return "ShowQuery" ;
        }catch (Exception e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}
