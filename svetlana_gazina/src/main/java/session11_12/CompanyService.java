package session11_12;

import java.util.List;

/**
 * Created by Sveta on 6/23/2015.
 */
public interface CompanyService {
    List<Object[]> getEmpFromCompany(String company);
    List<Object[]> getEmpFromAllCompanies();

}
