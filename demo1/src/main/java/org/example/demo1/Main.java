package org.example.demo1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.demo1.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Create a new employee
        Employee employee = new Employee("Amine Chaguer", "2003-07-12", "123 Agadir St", "H992012", "2025-01-01", "Developer", 90000, 5);
        entityManager.persist(employee);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
