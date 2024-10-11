package org.example.demo1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.model.Employee;
import org.example.demo1.service.EmployeeService;
import org.example.demo1.service.EmployeeServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddEmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        employeeService = new EmployeeServiceImpl();
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String name = request.getParameter("name");
        String birthDateStr = request.getParameter("birth_date");
        String address = request.getParameter("address");
        String socialSecurityNumber = request.getParameter("social_security_number");
        String hireDateStr = request.getParameter("hire_date");
        String position = request.getParameter("position");
        String salaryStr = request.getParameter("salary");  // Salary will be parsed to double
        String childrenStr = request.getParameter("children");  // Children will be parsed to int

        // Parse the salary and children
        double salary = 0.0;
        int children = 0;
        try {
            salary = Double.parseDouble(salaryStr);
            children = Integer.parseInt(childrenStr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Handle invalid input for salary or children
            request.setAttribute("error", "Invalid input for salary or children.");
            request.getRequestDispatcher("/addEmployee.jsp").forward(request, response);
            return;
        }

        // Parse the birth date and hire date
        LocalDate birthDate = null;
        LocalDate hireDate = null;
        try {
            birthDate = LocalDate.parse(birthDateStr); // Parse birth date
         } catch (DateTimeParseException e) {
            e.printStackTrace();
            // Handle invalid date input
            request.setAttribute("error", "Invalid date format for birth date or hire date.");
            request.getRequestDispatcher("/addEmployee.jsp").forward(request, response);
            return;
        }

        // Create a new Employee object and set the fields
        Employee employee = new Employee();
        employee.setName(name);
        employee.setBirthDate(birthDate.toString()); // Store date as String if necessary
        employee.setAddress(address);
        employee.setSocialSecurityNumber(socialSecurityNumber);
        employee.setHireDate(hireDate.toString()); // Store date as String if necessary
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setChildren(children);

        try {
            // Call the service to add the employee
            employeeService.addEmployee(employee);
            response.sendRedirect("success.jsp"); // Redirect to success page or confirmation page
        } catch (Exception e) {
            e.printStackTrace();
            // Optionally, set an error message and forward back to the form
            request.setAttribute("error", "Error adding employee: " + e.getMessage());
            request.getRequestDispatcher("/addEmployee.jsp").forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the JSP page to display the form
        request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
    }

}
