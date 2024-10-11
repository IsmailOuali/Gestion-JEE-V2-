package org.example.demo1.repository;

import org.example.demo1.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void deleteEmployee(int id);
}
