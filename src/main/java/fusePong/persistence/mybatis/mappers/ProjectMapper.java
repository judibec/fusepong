package fusePong.persistence.mybatis.mappers;

import fusePong.entities.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {
    public List<Project> consultProyectosEmpresa(@Param("email") String email);

    public List<Project> consultProyectos();
}
