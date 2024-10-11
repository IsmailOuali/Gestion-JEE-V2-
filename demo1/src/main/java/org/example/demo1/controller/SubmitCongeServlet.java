package org.example.demo1.controller;


import org.example.demo1.model.DemandeConge;
import org.example.demo1.model.Employee;
import org.example.demo1.util.EntityManagerUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class SubmitCongeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        System.out.println("Employe Name: " + req.getParameter("employe_name"));
        System.out.println("Conge Type: " + req.getParameter("conge_type"));
        System.out.println("Conge Start: " + req.getParameter("dateDebut"));
        System.out.println("Conge End: " + req.getParameter("dateFin"));

        try {
            em.getTransaction().begin();

            int employeeId = Integer.parseInt(req.getParameter("employeeId"));
            Employee employee = em.find(Employee.class, employeeId);

            LocalDate dateDebut = LocalDate.parse(req.getParameter("dateDebut"));
            LocalDate dateFin = LocalDate.parse(req.getParameter("dateFin"));
            String motif = req.getParameter("motif");

            DemandeConge demandeConge = new DemandeConge(employee, dateDebut, dateFin, motif);


            em.persist(demandeConge);
            em.getTransaction().commit();

            System.out.println("Request submitted");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("demandeCongee.jsp");
    }

//    private boolean checkForOverlappingLeaves(Employee employee, LocalDate start, LocalDate end, EntityManager em) {
//        String query = "SELECT COUNT(d) FROM DemandeConge d WHERE d.employee = :employee " +
//                "AND d.statut = :statut AND ((d.dateDebut BETWEEN :start AND :end) " +
//                "OR (d.dateFin BETWEEN :start AND :end))";
//
//        Long count = em.createQuery(query, Long.class)
//                .setParameter("employee", employee)
//                .setParameter("statut", DemandeConge.StatutDemande.APPROVED)
//                .setParameter("start", start)
//                .setParameter("end", end)
//                .getSingleResult();
//
//        return count == 0;
//    }
}

