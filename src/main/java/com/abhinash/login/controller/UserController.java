package com.abhinash.login.controller;

import com.abhinash.login.model.Employee;
import com.abhinash.login.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Employee> employees=employeeService.getEmployeeList();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "employee/empAdd";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeService.save(employee);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        Employee employee=employeeService.findUserById(id);
        model.addAttribute("user", employee);
        return "employee/empEdit";
    }

    @RequestMapping("/edit")
    public String edit(Employee employee) {
        employeeService.edit(employee);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/list";
    }

}
