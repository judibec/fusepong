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
@ManagedBean(name="TicketBean")
@SessionScoped
public class TicketBean extends BasePageBean{
    @Inject
    private TicketsServices ticketsServices;

    public void deleteTicket(int storyId) throws IOException {
        ticketsServices.deletedTicket(storyId);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/tickets/historias.xhtml");
    }

    public void editedTicket(int storyId,String estado) throws IOException {
        ticketsServices.editedTicket(storyId,estado);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("/tickets/historias.xhtml");
    }

    public void registerTicket(String descripcion, int idHistoria, String estado, String comentario) throws IOException {
        try {
            if((descripcion.trim().isEmpty() || descripcion.equals(null)) && (estado.trim().isEmpty() || descripcion.equals(null))){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Todos los campos deben estar llenos"));
            }else {
                ticketsServices.registerTicket(descripcion, idHistoria, estado, comentario);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().redirect("/tickets/historias.xhtml");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", " Se ha agregado la historia");
                PrimeFaces.current().dialog().showMessageDynamic(message);
            }
        }catch (IOException | PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }

    }

}
