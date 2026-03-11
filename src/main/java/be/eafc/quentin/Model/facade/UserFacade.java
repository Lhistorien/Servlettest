package be.eafc.quentin.Model.facade;

import be.eafc.quentin.Model.service.UserService;

public class UserFacade {
    private UserService userService = new UserService();

    public boolean userExists(String firstname, String lastname) {
        return userService.userExists(firstname, lastname);
    }
}
