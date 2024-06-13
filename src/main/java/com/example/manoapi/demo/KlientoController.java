package com.example.manoapi.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.manoapi.demo.DuombazesValdymas._connection;
import static com.example.manoapi.demo.Klientas.klientuSarasas;

@RestController
public class KlientoController {


    @GetMapping("/klientas")
    public String firstEndpoint(String username, String password) throws SQLException {
        DuombazesValdymas DV = new DuombazesValdymas();
        DV.klientuSarasasIsSqlBazes();
        for (Klientas a : klientuSarasas) {
            if (Objects.equals(a.getUsername(), username) && Objects.equals(a.getPassword(), password)) {
                return String.valueOf(a.getId());
            }
        }
        return null;
    }
    @GetMapping("/klientoRegistracijaSql")
    public String registruojamKlientaYSql(String username, String password) throws SQLException {
        DuombazesValdymas DV = new DuombazesValdymas();
        DV.klientoRegistracija(username,password);
        return "Klientas TURĖTŲ būti priregistruotas :)";
    }
    @GetMapping("/klientoDuomenuRegistracijaSql")
    public String klientoDuomenuRegistracija(String vardas, String pavarde, String miestas, String telNumeris) throws SQLException {
        DuombazesValdymas DV = new DuombazesValdymas();
        DV.klientoDuomenuRegistracija(vardas,pavarde,miestas,telNumeris);
        return "Kliento duomenys TURĖTŲ būti priregistruoti :)";
    }

}


