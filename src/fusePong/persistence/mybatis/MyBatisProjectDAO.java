package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.persistence.ProjectDAO;
import fusePong.persistence.mybatis.mappers.ProjectMapper;

public class MyBatisProjectDAO implements ProjectDAO {

    @Inject
    public ProjectMapper projectMapper;

}
