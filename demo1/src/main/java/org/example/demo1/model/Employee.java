package org.example.demo1.model;

import jakarta.persistence.*;  // Use javax.persistence if using older versions of JPA

@Entity
@Table(name = "employees")   // Map this class to the "employees" table in the database
public class    Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incremented primary key
    private int id;

    @Column(name = "name", nullable = false)  // Map field to a database column
    private String name;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "social_security_number", unique = true, nullable = false)
    private String socialSecurityNumber;

    @Column(name = "hire_date", nullable = false)
    private String hireDate;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "salary", nullable = false)
    private double salary;

    @Column(name = "children", nullable = false)
    private int children;

    // Constructors
    public Employee() {}

    public Employee(String name, String birthDate, String address, String socialSecurityNumber, String hireDate, String position, double salary, int children) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.socialSecurityNumber = socialSecurityNumber;
        this.hireDate = hireDate;
        this.position = position;
        this.salary = salary;
        this.children = children;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getSocialSecurityNumber() { return socialSecurityNumber; }
    public void setSocialSecurityNumber(String socialSecurityNumber) { this.socialSecurityNumber = socialSecurityNumber; }

    public String getHireDate() { return hireDate; }
    public void setHireDate(String hireDate) { this.hireDate = hireDate; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }
}
