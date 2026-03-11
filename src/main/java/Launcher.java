import be.eafc.quentin.Model.DAO.AbstractDAOFactory;
import be.eafc.quentin.Model.DAO.MySQLDAO.MySQLConnectionFactory;
import be.eafc.quentin.Model.DAO.MySQLDAO.MySQLDAOFactory;
import be.eafc.quentin.Model.DAO.UserDAO;
import be.eafc.quentin.Model.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main (String[] args) {
        AbstractDAOFactory.setFactory(MySQLDAOFactory.getInstance());

        UserDAO userDAO = AbstractDAOFactory.getFactory().createUserDAO();

        List<User> users = userDAO.getAllUsers();
        for(User user : users) {
            System.out.println(user);
        }
    }
}
