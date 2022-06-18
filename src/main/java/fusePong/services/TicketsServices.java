package fusePong.services;

import fusePong.entities.Company;
import fusePong.entities.Project;
import fusePong.entities.Stories;
import fusePong.entities.Tickets;

import java.util.List;

public interface TicketsServices {

    public Integer getNit(String company);

    public List<Company> getEmpresas();

    public List<Project> consultProyectosEmpresa(String email);

    public List<Project> consultProyectos();

    public List<Stories> getProjectStories(int projectId);

    public List<Tickets> getStoriesTicket(int storyId);

    public void deletedStory(int storyId);

    public void editedStory(int storyId, String estado);

    public void register(String descripcion,int idProyecto, String estado);

    public void deletedTicket(int ticketId);

    public void editedTicket(int ticketId, String estado);

    public void registerTicket(String descripcion,int storyId, String estado, String comentario);
}
