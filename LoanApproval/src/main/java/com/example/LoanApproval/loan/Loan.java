package com.example.LoanApproval.loan;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Loan {
    @Id
    String id;
    private String nom;
    private float somme;

    public Loan() {
    }

    public Loan(String id, String nom, float somme) {
        this.id = id;
        this.nom = nom;
        this.somme = somme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getSomme() {
        return somme;
    }

    public void setSomme(float somme) {
        this.somme = somme;
    }
}
