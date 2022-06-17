package fusePong.services.impl;

import com.google.inject.Inject;
import fusePong.entities.Company;
import fusePong.entities.Project;
import fusePong.entities.Stories;
import fusePong.persistence.*;
import fusePong.services.TicketsServices;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class TicketsServicesImpl implements TicketsServices {

    @Inject
    private CompanyDAO companyDAO;

    @Inject
    private ProjectDAO projectDAO;

    @Inject
    private StoriesDAO storiesDAO;

    @Inject
    private TicketsDAO ticketsDAO;

    @Inject
    private UserDAO userDAO;

    @Override
    public int getNit(String company) {
        try{
            return companyDAO.getNit(company);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Company> getEmpresas() {
        try{
            return companyDAO.getEmpresas();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Project> consultProyectosEmpresa(String email) {
        try{
            return projectDAO.consultProyectosEmpresa(email);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Project> consultProyectos() {
        try{
            return projectDAO.consultProyectos();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Stories> getProjectStories(int projectId) {
        try{
            return storiesDAO.getProjectStories(projectId);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void deletedStory(int storyId) {
        try{
            storiesDAO.deletedStory(storyId);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void editedStory(int storyId, String estado) {
        try{
            storiesDAO.editedStory(storyId,estado);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void register(String descripcion, int idProyecto, String estado) {
        try{
            storiesDAO.register(descripcion,idProyecto,estado);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }


}
