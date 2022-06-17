package fusePong.persistence.mybatis.mappers;

import fusePong.entities.Stories;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoriesMapper {
    public List<Stories> getProjectStories(@Param("projectId") int projectId);

    public void deletedStory(@Param("storyId") int storyId);

    public void editedStory(@Param("storyId") int storyId,@Param("estado")String estado);

    public void register(@Param("descripcion") String descripcion,@Param("idProyecto")int idProyecto,@Param("estado")String estado);
}
