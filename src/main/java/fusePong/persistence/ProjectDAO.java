package fusePong.persistence;

import fusePong.entities.Project;

import java.util.List;

public interface ProjectDAO {
    public List<Project> consultProyectosEmpresa(String email);

    public List<Project> consultProyectos();
}
