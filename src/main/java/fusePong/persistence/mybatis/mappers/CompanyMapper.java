package fusePong.persistence.mybatis.mappers;

import fusePong.entities.Company;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CompanyMapper {
    public int getNit(@Param("company") String company);

    public List<Company> getEmpresas();
}
