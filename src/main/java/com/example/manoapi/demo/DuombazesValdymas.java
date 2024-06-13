package com.example.manoapi.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.manoapi.demo.Klientas.klientuSarasas;

public class DuombazesValdymas {
    final String URL = "jdbc:mysql://localhost:3306/javadarbas";
    final String USERNAME = "root";
    final String PASSWORD = "l3g10n4s";
    public static Connection _connection;

    public DuombazesValdymas(String URL, String USERNAME, String PASSWORD) throws SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public DuombazesValdymas() throws SQLException {
        _connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<Klientas> klientuSarasasIsSqlBazes() throws SQLException {
        String sql = "SELECT * FROM klientai2";
        PreparedStatement statement = _connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            Klientas klientas = new Klientas(id, username, password);
            klientuSarasas.add(klientas);
        }
        return klientuSarasas;
    }

    public void klientoRegistracija(String username, String password) throws SQLException {
        String insertSQL = "INSERT INTO klientai2 (username,password) VALUE (?, ?)";

        // Try-with-resources to auto close connection, statement, and result set
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
        }
    }
    public void klientoDuomenuRegistracija(String vardas, String pavarde, String miestas, String telNumeris) throws SQLException {
        String insertSQL = "INSERT INTO kliento_duomenys (vardas,pavarde,miestas,tel_numeris) VALUE (?, ?, ?, ?)";

        // Try-with-resources to auto close connection, statement, and result set
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, vardas);
            preparedStatement.setString(2, pavarde);
            preparedStatement.setString(3, miestas);
            preparedStatement.setString(4, telNumeris);
            preparedStatement.executeUpdate();
        }
    }
}
