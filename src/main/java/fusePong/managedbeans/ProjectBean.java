package fusePong.managedbeans;

import com.google.inject.Inject;
import fusePong.entities.Project;
import fusePong.entities.Stories;
import fusePong.services.TicketsServices;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name="ProjectBean")
@SessionScoped
public class ProjectBean extends BasePageBean{

    @Inject
    private TicketsServices ticketsServices;

    private Project project;
    private int projectId;
    private List<Stories> projectStories = new ArrayList<Stories>();

    public List<Project> getProyectosEmpresa(String email){
        return ticketsServices.consultProyectosEmpresa(email);
    }

    public List<Project> getProjects(){
        return ticketsServices.consultProyectos();
    }
     public Project getProject(){
        return project;
     }

     public void getProjectStories(int proyectoId) throws IOException {
        this.projectId = proyectoId;
        projectStories = ticketsServices.getProjectStories(proyectoId);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/tickets/historias.xhtml");
     }

     public List<Stories> getProjectStories(){
        return projectStories;
     }

    public int getProjectId() {
        return projectId;
    }
}
