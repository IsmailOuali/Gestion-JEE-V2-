package org.example.demo1.controller;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.model.DemandeConge;
import org.example.demo1.util.EntityManagerUtil;

import java.io.IOException;

public class ProcessCongeServlet extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = EntityManagerUtil.getEntityManager();
        int demandeId = Integer.parseInt(req.getParameter("demandeId"));
        String action = req.getParameter("action");

        try {
            em.getTransaction().begin();

            DemandeConge demandeConge = em.find(DemandeConge.class, demandeId);
            if ("approve".equals(action)) {
                demandeConge.setStatut(DemandeConge.StatutDemande.APPROVED);
            } else if ("reject".equals(action)) {
                demandeConge.setStatut(DemandeConge.StatutDemande.REJECTED);
            }

            em.getTransaction().commit();
            resp.sendRedirect("listPendingRequests.jsp");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        } finally {
            em.close();
        }
    }
}

