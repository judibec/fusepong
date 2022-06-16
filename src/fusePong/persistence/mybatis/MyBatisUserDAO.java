package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.persistence.UserDAO;
import fusePong.persistence.mybatis.mappers.UserMapper;

public class MyBatisUserDAO implements UserDAO {

    @Inject
    private UserMapper userMapper;
}
