package com.liang.controller;

import com.liang.dao.EmployeeDao;
import com.liang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @description:
 * @author:Lenovo
 * @date:2020-11-03 2020/11/3
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping("/employee/queryAll")
    public String queryAll(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "employee/queryAll";
    }
    @RequestMapping("/employee/delete/{id}")
    public String delete(@PathVariable("id") int id){
        employeeDao.delete(id);
        return "redirect:/employee/queryAll";
    }
    @RequestMapping("/employee/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id,Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "/employee/toUpdate";
    }
    @RequestMapping("/employee/update")
    @ResponseBody
    public String update(){
        return "helllo update!";
//        employeeDao.update(employee);
//        return "redirect:/employee/queryAll";
    }
}
