package fusePong.managedbeans;

import com.google.inject.Inject;
import fusePong.entities.Company;
import fusePong.services.TicketsServices;
import fusePong.services.UserServices;
import org.apache.ibatis.exceptions.PersistenceException;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="RegistrarBean")
@ApplicationScoped

public class RegistrarBean extends BasePageBean{

    @Inject
    private UserServices userServices;

    @Inject
    private TicketsServices ticketsServices;

    private String name;
    private String email;
    private String password;
    private Integer company;
    private String empresa;

    @PostConstruct
    public void init(){
        super.init();
    }

    private List<String> nombres = new ArrayList<String>();

    public void registrarUsuario(){
        try{
            if(name.trim().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Nombre requerido"));
            }if(email.trim().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Email requerido"));
            }if(password.trim().isEmpty()){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Password requerido"));
            }else{
                System.out.println(empresa);
                company=getNit(empresa);
                System.out.println(company);
                userServices.registrarUsuario(name,email,password,company);
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

    public Integer getNit(String company){
        return ticketsServices.getNit(company);
    }

    public List<Company> getEmpresas(){
        return ticketsServices.getEmpresas();
    }

    public List<String> getEmpresasNombre(){
        List<Company> empresa = ticketsServices.getEmpresas();
        for (Company company : empresa) {
            nombres.add(company.getName());
        }
        return nombres;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
