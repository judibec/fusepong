package fusePong.persistence.mybatis;

import com.google.inject.Inject;
import fusePong.persistence.CompanyDAO;
import fusePong.persistence.mybatis.mappers.CompanyMapper;

public class MyBatisCompanyDAO implements CompanyDAO {

    @Inject
    private CompanyMapper companyMapper;
}
