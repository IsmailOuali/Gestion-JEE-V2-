package org.example.demo1.service;

import org.example.demo1.model.Employee;
import org.example.demo1.repository.EmployeeRepository;
import org.example.demo1.repository.EmployeeRepositoryImpl;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl() {
        this.employeeRepository = new EmployeeRepositoryImpl(); // Ensure this is not null
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
