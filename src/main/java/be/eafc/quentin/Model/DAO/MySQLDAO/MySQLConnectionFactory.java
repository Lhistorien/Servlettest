package be.eafc.quentin.Model.DAO.MySQLDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory {

    private static MySQLConnectionFactory instance;

    private MySQLConnectionFactory(){};

    public static MySQLConnectionFactory getInstance() {
        if (instance == null) {
            synchronized (MySQLConnectionFactory.class) {
                if (instance == null) {
                    instance = new MySQLConnectionFactory();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        String dburl = "jdbc:mysql://127.0.0.1:3306/testservlet";
        Connection c = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(dburl, "root", null);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: " + cnfe.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return c;
    }

    public static void closeConnection (Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e ){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
