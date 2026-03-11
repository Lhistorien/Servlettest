package be.eafc.quentin.Model.service;

import be.eafc.quentin.Model.DAO.AbstractDAOFactory;
import be.eafc.quentin.Model.DAO.MySQLDAO.MySQLDAOFactory;
import be.eafc.quentin.Model.DAO.UserDAO;
import be.eafc.quentin.Model.User;

import java.util.List;

public class UserService {
    public boolean userExists(String firstname, String lastname) {
        AbstractDAOFactory.setFactory(MySQLDAOFactory.getInstance());
        UserDAO userDAO = AbstractDAOFactory.getFactory().createUserDAO();
        List<User> users = userDAO.getAllUsers();

        User toSearch = new User(firstname, lastname);
        return users.contains(toSearch);
    }
}