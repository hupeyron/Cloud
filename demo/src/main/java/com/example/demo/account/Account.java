package com.example.demo.account;

public class Account {

    private String nom;
    private String prenom;
    private int num;
    private String risk;

    public Account() {
    }

    public Account(String nom, String prenom, int num, String risk) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.risk = risk;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNum() {
        return num;
    }

    public String getRisk() {
        return risk;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "Account{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", num=" + num +
                ", risk='" + risk + '\'' +
                '}';
    }
}
