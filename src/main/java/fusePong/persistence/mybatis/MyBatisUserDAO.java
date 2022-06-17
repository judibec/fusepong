package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.persistence.UserDAO;
import fusePong.persistence.mybatis.mappers.UserMapper;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBatisUserDAO implements UserDAO {

    @Inject
    private UserMapper userMapper;

    @Override
    public void registrarUsuario(String name, String email, String password, int company) {
        try {
            userMapper.registrarUsuario(name,email,password,company);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
