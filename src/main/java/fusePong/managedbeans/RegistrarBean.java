package fusePong.managedbeans;

import com.google.inject.Inject;
import fusePong.entities.Company;
import fusePong.services.TicketsServices;
import fusePong.services.UserServices;
import org.apache.ibatis.exceptions.PersistenceException;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="RegistrarBean")
@SessionScoped

public class RegistrarBean extends BasePageBean{

    @Inject
    private UserServices userServices;

    @Inject
    private TicketsServices ticketsServices;

    private String name;
    private String email;
    private String password;
    private int companyn;

    public void registrarUsuario(String name, String email, String password, String company){
        try{
            if(name==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Nombre requerido"));
            }if(email==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Email requerido"));
            }if(password==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","password requerido"));
            }if(company==null){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Company requerido"));
            }else{
                System.out.println(company.toString());
                this.name=name; this.email=email; this.password=password; this.companyn=getNit(company.toString());
                userServices.registrarUsuario(name,email,password,companyn);
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Se ha registrado el Usuario");
                PrimeFaces.current().dialog().showMessageDynamic(message);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/tickets/login.xhtml");
            }
        }catch (PersistenceException | IOException e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", e.getMessage()));
            throw new PersistenceException(e.getMessage());
        }
    }

    public int getNit(String company){
        return ticketsServices.getNit(company);
    }

    public List<Company> getEmpresas(){
        return ticketsServices.getEmpresas();
    }
}
