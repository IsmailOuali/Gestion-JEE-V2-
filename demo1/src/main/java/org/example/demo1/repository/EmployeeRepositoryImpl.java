package org.example.demo1.repository;

import jakarta.persistence.*;
import org.example.demo1.model.Employee;
import org.example.demo1.util.EntityManagerUtil;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public EmployeeRepositoryImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("demo1");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void addEmployee(Employee employee) {
        EntityTransaction transaction = null;
        try {
            // Start a transaction
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persist the employee entity
            entityManager.persist(employee);

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // Rollback if an error occurs
                transaction.rollback();
            }
            // Rethrow the exception or handle it
            throw e;
        }
    }


    @Override
    public List<Employee> getAllEmployees() {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        } finally {
            entityManager.close(); // Ensure EntityManager is closed
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        EntityManager entityManager = getEntityManager();
        try {
            return entityManager.find(Employee.class, id);
        } finally {
            entityManager.close(); // Ensure EntityManager is closed
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // Start the transaction
        try {
            entityManager.merge(employee);
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            transaction.rollback(); // Rollback in case of error
            throw e; // Rethrow the exception or handle it
        } finally {
            entityManager.close(); // Ensure EntityManager is closed
        }
    }

    @Override
    public void deleteEmployee(int id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // Start the transaction
        try {
            Employee employee = getEmployeeById(id);
            if (employee != null) {
                entityManager.remove(employee);
            }
            transaction.commit(); // Commit the transaction
        } catch (Exception e) {
            transaction.rollback(); // Rollback in case of error
            throw e; // Rethrow the exception or handle it
        } finally {
            entityManager.close(); // Ensure EntityManager is closed
        }
    }
}
