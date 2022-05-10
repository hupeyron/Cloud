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
}
