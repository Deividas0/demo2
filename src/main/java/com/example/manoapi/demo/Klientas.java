package com.example.manoapi.demo;

import java.util.ArrayList;
import java.util.List;

public class Klientas {
    int id;
    String username;
    String password;
    String vardas;
    String pavarde;
    String miestas;
    String telNumeris;
    public static List<Klientas> klientuSarasas = new ArrayList<>();


    public Klientas(int id, String username, String password) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public int getId() {return id;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}

    public String getVardas() {return vardas;}
    public String getPavarde() {return pavarde;}
    public String getMiestas() {return miestas;}
    public String getTelNumeris() {return telNumeris;}

    @Override
    public String toString(){
        return "Kliento ID: " + getId() + ". Kliento username: " + getUsername() + ". Slaptažodis: " + getPassword() + ". ";
    }
}
