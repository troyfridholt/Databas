package com.example.databasjava;

import java.sql.*;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/movie_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

    public ResultSet searchFilms(String query) throws SQLException {
        String sql = "SELECT * FROM films WHERE title LIKE '%" + query + "%'";
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

}
