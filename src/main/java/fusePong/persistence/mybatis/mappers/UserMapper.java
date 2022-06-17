package fusePong.persistence.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public void registrarUsuario(@Param("nombre") String name, @Param("correo")String email, @Param("contraseña")String password, @Param("empresa") int company);
}
