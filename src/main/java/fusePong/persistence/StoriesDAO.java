package fusePong.persistence;

import fusePong.entities.Stories;

import java.util.List;

public interface StoriesDAO {
    public List<Stories> getProjectStories(int projectId);

    public void deletedStory(int storyId);

    public void editedStory(int storyId,String estado);
}
