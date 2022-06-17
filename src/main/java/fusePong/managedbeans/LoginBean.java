package fusePong.managedbeans;

import com.google.inject.Inject;
import fusePong.login.LoginServices;
import fusePong.services.ServicesException;
import fusePong.services.UserServices;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@ApplicationScoped

public class LoginBean extends BasePageBean{
    private String email;

    @Inject
    private LoginServices loginServices;

    @Inject
    private UserServices userServices;

    private boolean showReserve;

    private boolean showColumn;

    public void singIn(String email, String password) throws ServicesException, IOException {
        try {
            if (email.trim().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Correo requerido"));
            }else if (password.trim().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Contraseña requerida"));
            }else {
                loginServices.singIn(email, password, false);
                this.email=email;
                FacesContext.getCurrentInstance().getExternalContext().redirect("/tickets/proyectos.xhtml");
            }
        }catch (ServicesException servicesException){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",servicesException.getMessage()));
        }
    }

    public void reserveUrl(){
        System.out.println("Click");
    }

    public String textLog(){
        if(loginServices.isLoggedIn()){
            return "Cerrar Sesión";
        }else {
            return "Iniciar Sesión";
        }
    }

    public boolean isShowReserve() {
        return loginServices.isLoggedIn();
    }

    public String textReserve(){
        if(loginServices.isLoggedIn()){
            return "Ver mis reservas";
        }else{
            return null;
        }
    }

    public void actionButton() throws IOException {
        if(loginServices.isLoggedIn()){
            loginServices.logOut();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/tickets/login.xhtml");
        }
    }

//    public void actionReserve() throws IOException {
//        FacesContext.getCurrentInstance().getExternalContext().redirect("/gestor/reservation.xhtml");
//    }

//    public List<User> getUsers() {
//        return gestorServices.consultUsers();
//    }

    public String getEmail(){return email;}

//    public User consultUser(String email) throws ServicesException {
//        return gestorServices.consultUser(email);
//    }

    public boolean isShowColumn(){
        if(loginServices.isLoggedIn() && userServices.isAdmin()){
            return true;
        }else{
            return false;
        }
    }
}
