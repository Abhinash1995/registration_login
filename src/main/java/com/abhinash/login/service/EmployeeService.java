package com.abhinash.login.service;

import com.abhinash.login.model.Employee;
import com.abhinash.login.repository.EmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepos employeeRepos;

    public List<Employee> getEmployeeList(){
        return employeeRepos.findAll();
    }

    public Employee findUserById(Long id){
        return employeeRepos.findEmployeeById(id);
    }

    public Employee save(Employee employee){
        return employeeRepos.save(employee);
    }

    public Employee edit(Employee employee){
        return employeeRepos.save(employee);
    }

    public void delete(Long id){
        employeeRepos.deleteById(id);
    }
}
