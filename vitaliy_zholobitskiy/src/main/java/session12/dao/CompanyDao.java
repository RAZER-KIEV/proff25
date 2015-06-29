package session12.dao;

/**
 * Created by just1ce on 23.06.2015.
 */
import hw6.notes.domain.Notebook;
import session12.domain.Company;

import java.util.Date;
import java.util.List;

public interface CompanyDao {
    boolean update(Company ntb);
    boolean delete(Company ntb);
    List findEmpFromCompany(String company);
    List getAll();
    List getCompaniesByCountEmpl(int count);

}

