package database;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection;

    public boolean loadDataBaseDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean makeConnection() {
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://databases.aii.avans.nl/jaydiele_db2?user=jhwcolde&password=Ab12345");
            System.out.println("Database is connected...");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
        return true;
    }

    public void showAccountQuery() {

        PreparedStatement statement = null;
        String query = "SELECT * FROM account ";
        String username, password;

        try {
            statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                username = result.getString("username");
                password = result.getString("password");
                System.out.println("Gebruikersnaam: " + username + ", Wachtwoord: " + password + ".");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}