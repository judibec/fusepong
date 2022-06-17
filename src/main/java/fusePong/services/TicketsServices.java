package fusePong.services;

import fusePong.entities.Company;
import fusePong.entities.Project;
import fusePong.entities.Stories;

import java.util.List;

public interface TicketsServices {

    public int getNit(String company);

    public List<Company> getEmpresas();

    public List<Project> consultProyectosEmpresa(String email);

    public List<Project> consultProyectos();

    public List<Stories> getProjectStories(int projectId);

    public void deletedStory(int storyId);

    public void editedStory(int storyId, String estado);

    public void register(String descripcion,int idProyecto, String estado);
}
