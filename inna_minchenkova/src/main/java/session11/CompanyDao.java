package session11;

import java.util.List;

/**
 * Created by Inna on 22.06.2015.
 */
public interface CompanyDao {
    Long create(Company company);

    Company read(String id);

    boolean update(Company company);

    void delete(Company company);

    public List<Company> findAll();

    public List<Company> findEmployee();
}
