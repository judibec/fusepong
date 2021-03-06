package fusePong.managedbeans;


import com.google.inject.Inject;
import fusePong.entities.Stories;
import fusePong.entities.Tickets;
import fusePong.services.TicketsServices;
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
@ManagedBean(name="StoryBean")
@SessionScoped
public class StoriesBean extends BasePageBean{

    @Inject
    private TicketsServices ticketsServices;

    private int storyId;
    private List<Tickets> storiesTicket = new ArrayList<Tickets>();


    public void deleteStory(int storyId) throws IOException {
        ticketsServices.deletedStory(storyId);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/tickets/proyectos.xhtml");
    }

    public void editedStory(int storyId,String estado) throws IOException {
        ticketsServices.editedStory(storyId,estado);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/tickets/proyectos.xhtml");
    }

    public void register(String descripcion, int idProyecto, String estado) throws IOException {
        try {
            if((descripcion.trim().isEmpty() || descripcion.equals(null)) && (estado.trim().isEmpty() || descripcion.equals(null))){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Todos los campos deben estar llenos"));
            }else {
                ticketsServices.register(descripcion, idProyecto, estado);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().redirect("/tickets/proyectos.xhtml");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Se ha agregado la historia");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }catch (IOException | PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }

    }

    public void getStoriesTicket(int storyId) throws IOException {
        this.storyId = storyId;
        storiesTicket = ticketsServices.getStoriesTicket(storyId);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/tickets/tickets.xhtml");
    }

    public List<Tickets> getStoriesTicket(){
        return storiesTicket;
    }

    public int getStoryId() {
        return storyId;
    }
}
