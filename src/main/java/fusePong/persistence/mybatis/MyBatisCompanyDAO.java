package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.entities.Company;
import fusePong.persistence.CompanyDAO;
import fusePong.persistence.mybatis.mappers.CompanyMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisCompanyDAO implements CompanyDAO {

    @Inject
    private CompanyMapper companyMapper;

    @Override
    public int getNit(String company) {
        try{
            return companyMapper.getNit(company);
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<Company> getEmpresas() {
        try{
            return companyMapper.getEmpresas();
        }catch (PersistenceException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
