package session14.dao;

import org.springframework.transaction.annotation.Transactional;
import session14.domain.Company;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.03.15
 */
public interface CompanyDao {
    void create(Company client);

    @Transactional(readOnly = true)
    Company read(Long id);

    void update(Company client);

    void delete(Company client);

    @Transactional(readOnly = true)
    List<Company> findAll();

    List<Company> findMonyGT(long amount);
}
