package org.example.demo1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "demandes_conges")
public class DemandeConge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "motif", nullable = false)
    private String motif;

    @Column(name = "statut", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatutDemande statut;

    // Enum to track status of the leave request (Pending, Approved, Rejected)
    public enum StatutDemande {
        PENDING,
        APPROVED,
        REJECTED
    }

    // Constructors, getters, and setters
    public DemandeConge() {}

    public DemandeConge(Employee employee, LocalDate dateDebut, LocalDate dateFin, String motif) {
        this.employee = employee;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.statut = StatutDemande.PENDING;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public String getMotif() {
        return motif;
    }
    public void setMotif(String motif) {
        this.motif = motif;
    }
    public StatutDemande getStatut() {
        return statut;
    }
    public void setStatut(StatutDemande statut) {
        this.statut = statut;
    }
}
