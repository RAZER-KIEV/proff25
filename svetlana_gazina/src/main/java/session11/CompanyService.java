package session11;

import java.util.List;
import java.util.Objects;

/**
 * Created by Sveta on 6/23/2015.
 */
public interface CompanyService {
    List<Object[]> getEmpFromCompany(String company);
    List<Object[]> getEmpFromAllCompanies();

}
