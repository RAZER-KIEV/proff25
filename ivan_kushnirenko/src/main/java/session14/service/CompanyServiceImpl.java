package session14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session14.dao.CompanyDao;
import session14.dao.CompanyDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ivan on 30.06.15.
 */
@Service
@Transactional
public class CompanyServiceImpl {


    private CompanyDaoImpl companyDao;

    private String getData() {
        System.out.println("Please, type company name: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        do {
            if (s.length() == 0) {
                System.out.println("ERROR: Company name must be non empty!");
            }
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR.");
            }
        } while (s.equals(""));
        return s;
    }

    @Transactional(readOnly = true)
    public void showAllEmployessByCompanyName() {
        companyDao.findCompanyByName(getData());
    }

    public static void main(String[] args) {
    }
}
