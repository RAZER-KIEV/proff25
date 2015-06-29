package session12.dao;

import session11.Company;
import session11.Emploee;

import java.util.Set;

/**
 * Created by RAZER on 23.06.2015.
 */
public interface DaoCompany {

    void create(Company company);
    void create(Emploee emploee);

    Set<Object[]> getEmploeesFromCompany(Company company);
    Set<Emploee>  getEmploeesFromAllCompanys();

}
