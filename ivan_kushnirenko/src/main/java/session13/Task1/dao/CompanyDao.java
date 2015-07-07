package session13.Task1.dao;

import session13.Task1.domain.Company;

import java.util.List;

/**
 * Created by ivan on 29.06.15.
 */
public interface CompanyDao {

    Long create(Company company);

    Company read(Long id);

    boolean update(Company company);

    boolean delete(Company company);

    List findAll();
}
