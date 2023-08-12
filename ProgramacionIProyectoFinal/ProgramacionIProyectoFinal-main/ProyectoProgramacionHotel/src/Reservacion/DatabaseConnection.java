package Reservacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private static Connection connection;
    private final String DATABASE_URL = "jdbc:mysql://localhost/hotel_db";
    private final String DATABASE_USER = "root";
    private final String DATABASE_PASSWORD = "Allison.031"; 

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

	
}

