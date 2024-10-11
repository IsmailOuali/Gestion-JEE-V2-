package org.example.demo1.service;

import org.example.demo1.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
}
