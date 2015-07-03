package week6_lesson11.service;

import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;

/**
 * Created by HP on 24.06.2015.
 */
public interface CompEmplService {
    Company readComp(Long id);
    Employee readEmpl (Long id);
}
