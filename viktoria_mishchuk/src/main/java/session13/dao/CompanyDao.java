package session13.dao;

import session13.Company;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session13.dao
 */
public interface CompanyDao {

    Long create(Company company);
    session13.domain.Company read(Long ig);
    boolean update(Company company);
    boolean delete(Company company);
    List findAll();

}
