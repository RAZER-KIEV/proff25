package session14.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import session14.service.CompanyService;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 24.03.15
 */
@Component
public class View {
    @Autowired
    private CompanyService companyService;

    @PostConstruct
    public void menu() {
        companyService.getByName("Roga i kopyta");
    }
}
