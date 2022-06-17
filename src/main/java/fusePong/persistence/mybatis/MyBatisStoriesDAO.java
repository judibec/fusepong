package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.entities.Stories;
import fusePong.persistence.StoriesDAO;
import fusePong.persistence.mybatis.mappers.StoriesMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisStoriesDAO implements StoriesDAO {

    @Inject
    private StoriesMapper storiesMapper;

    @Override
    public List<Stories> getProjectStories(int projectId) {
        try{
            return storiesMapper.getProjectStories(projectId);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void deletedStory(int storyId) {
        try{
            storiesMapper.deletedStory(storyId);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void editedStory(int storyId, String estado) {
        try{
            storiesMapper.editedStory(storyId,estado);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void register(String descripcion, int idProyecto, String estado) {
        try{
            storiesMapper.register(descripcion,idProyecto,estado);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
