package be.eafc.quentin.Model.DAO.MySQLDAO;

import be.eafc.quentin.Model.DAO.AbstractDAOFactory;
import be.eafc.quentin.Model.DAO.UserDAO;

import java.sql.Connection;

public class MySQLDAOFactory extends AbstractDAOFactory {

    private static MySQLDAOFactory instance;

    private MySQLDAOFactory(){};

    public static MySQLDAOFactory getInstance() {
        if (instance == null) {
            synchronized (MySQLDAOFactory.class) {
                if (instance == null) {
                    instance = new MySQLDAOFactory();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return MySQLConnectionFactory.getInstance().getConnection();
    }


    @Override
    public UserDAO createUserDAO() {
        return MySQLUserDAO.getInstance();
    }
}
