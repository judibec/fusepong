package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.entities.Project;
import fusePong.persistence.ProjectDAO;
import fusePong.persistence.mybatis.mappers.ProjectMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisProjectDAO implements ProjectDAO {

    @Inject
    public ProjectMapper projectMapper;

    @Override
    public List<Project> consultProyectosEmpresa(String email) {
        try{
            return projectMapper.consultProyectosEmpresa(email);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Project> consultProyectos() {
        try{
            return projectMapper.consultProyectos();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
