package com.example.AppManager.approval;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Approval {
    @Id
    String id;
    private String nom;
    enum Reponse {
        ACCEPTED,
        REFUSED,
    }
    private Reponse reponse;

    public Approval() {
    }

    public Approval(String id, String nom, Reponse reponse) {
        this.id = id;
        this.nom = nom;
        this.reponse = reponse;
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

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "id='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", reponse=" + reponse +
                '}';
    }
}
