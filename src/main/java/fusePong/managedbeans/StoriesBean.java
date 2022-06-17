package fusePong.managedbeans;


import com.google.inject.Inject;
import fusePong.entities.Stories;
import fusePong.services.TicketsServices;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name="StoryBean")
@SessionScoped
public class StoriesBean extends BasePageBean{

    @Inject
    private TicketsServices ticketsServices;

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
}
