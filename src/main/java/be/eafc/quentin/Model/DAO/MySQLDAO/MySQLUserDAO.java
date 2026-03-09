package be.eafc.quentin.Model.DAO.MySQLDAO;

import be.eafc.quentin.Model.DAO.UserDAO;
import be.eafc.quentin.Model.User;

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
        return List.of();
    }
}
