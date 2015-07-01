package session14.service;

import session14.domain.Company;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.03.15
 */
public interface CompanyService {
    Company getByName(String name);
}
