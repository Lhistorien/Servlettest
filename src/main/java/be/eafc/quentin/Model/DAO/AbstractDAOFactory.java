package be.eafc.quentin.Model.DAO;

public abstract class AbstractDAOFactory {
    private static AbstractDAOFactory factory;
    public static AbstractDAOFactory getFactory() {
        return factory;
    }

    public static void setFactory(AbstractDAOFactory factory) {
        AbstractDAOFactory.factory = factory;
    }

    public abstract UserDAO createUserDAO();
}
