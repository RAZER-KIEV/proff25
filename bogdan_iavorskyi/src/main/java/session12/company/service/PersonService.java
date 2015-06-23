package session12.company.service;

import session12.company.domain.Company;
import session12.company.domain.Person;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */
public interface PersonService {
    List listByCompany(String name);
    List listAll();
    List listCompaniesHireMoreThanXEmployees(int i);
}
