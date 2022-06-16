package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.persistence.StoriesDAO;
import fusePong.persistence.mybatis.mappers.StoriesMapper;

public class MyBatisStoriesDAO implements StoriesDAO {

    @Inject
    private StoriesMapper storiesMapper;
}
