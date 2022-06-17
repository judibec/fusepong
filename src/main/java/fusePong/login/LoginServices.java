package fusePong.login;

import fusePong.services.ServicesException;

public interface LoginServices {

    public void singIn(String email, String password, boolean rememberMe) throws ServicesException;

    public boolean isLoggedIn();

    public void logOut();
}
