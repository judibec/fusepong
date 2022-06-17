package fusePong.persistence;

import fusePong.entities.Company;

import java.util.List;

public interface CompanyDAO {
    public Integer getNit(String company);

    public List<Company> getEmpresas();
}
