package com.abhinash.login.repository;

import com.abhinash.login.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepos extends JpaRepository<Employee,Long> {

    Employee findEmployeeById(Long id);

    void deleteById(Long id);
}
