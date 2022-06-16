package fusePong.services.impl;

import com.google.inject.Inject;
import fusePong.persistence.UserDAO;
import fusePong.services.ServicesException;
import fusePong.services.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class UserServicesImpl implements UserServices {

    @Inject
    UserDAO userDAO;

    @Override
    public boolean isAdmin() {
        try {
            Subject subject = SecurityUtils.getSubject();
            return subject.hasRole("A");
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public String getEmail() throws ServicesException {
        Subject subject = SecurityUtils.getSubject();
        return subject.getPrincipals().toString();
    }
}
