package be.eafc.quentin.Model.DAO.MySQLDAO;

import be.eafc.quentin.Model.DAO.UserDAO;
import be.eafc.quentin.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserDAO {

    private static MySQLUserDAO instance;

    private MySQLUserDAO(){};

    public static MySQLUserDAO getInstance() {
        if (instance == null) {
            synchronized (MySQLUserDAO.class) {
                if (instance == null) {
                    instance = new MySQLUserDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection c = null;
        //Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT firstname, lastname FROM users";

        try {
            c = MySQLDAOFactory.getInstance().getConnection();
            //st = c.createStatement();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                users.add(new User(rs.getString("firstname"), rs.getString("lastname")));
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (ps!= null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            MySQLConnectionFactory.closeConnection(c);
        }
        return users;
    }
}
