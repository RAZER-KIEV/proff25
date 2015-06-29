package session11.Service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session11.dao.CompanyDaoImpl;
import session11.dao.EmployeeDaoImpl;
import session11.domain.Company;
import session11.domain.Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ivan on 23.06.15.
 */
public class Menu {

    private static Logger log = Logger.getLogger(Company.class);
    private CompanyDaoImpl cdi;
    private EmployeeDaoImpl edi;

    public CompanyDaoImpl getCdi() {
        return cdi;
    }
    public void setCdi(CompanyDaoImpl cdi) {
        this.cdi = cdi;
    }
    public EmployeeDaoImpl getEdi() {
        return edi;
    }
    public void setEdi(EmployeeDaoImpl edi) {
        this.edi = edi;
    }

    private void checkCompanyDaoImpl(){
        if (cdi==null){
            cdi = new CompanyDaoImpl();
        }
    }

    private void checkEmployeeDaoImpl(){
        if (edi==null){
            edi = new EmployeeDaoImpl();
        }
    }

    private static String getData(String sout) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String gettedData = "";
        System.out.println(sout);
        while (gettedData.length() == 0) {
            try {
                gettedData = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (gettedData.length() == 0) {
                System.out.println("Input parametr must be non-empty!");
                System.out.println("Re-type parametr:");
            }
        }
        return gettedData;
    }



    public void showEmployeesByCompany(){
        checkCompanyDaoImpl();
        String companyName = getData("Type the name of your company, please: ");
        List res = null;
        try{
             res = cdi.findCompanyEmployees(companyName);
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("ERROR: There is no such company: "+companyName+".");
            return;
        }
         if (res!=null){
             for (int j = 0; j < res.size(); j++) {
                 Object[] arrEmpl = (Object[])res.get(j);
                 for (int i = 0; i <arrEmpl.length; i++) {
                     System.out.println(arrEmpl[i]);
                 }
             }
         }
    }

    public void showAllEmployes(){
        checkEmployeeDaoImpl();
        List res = null;
        try{
            res = edi.showAllwithCompanies();
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("ERROR: There are no employees.");
            return;
        }
        if (res!=null){
            for (int j = 0; j < res.size(); j++) {
                Object[] arrEmpl = (Object[])res.get(j);
                for (int i = 0; i <arrEmpl.length; i++) {
                    System.out.println(arrEmpl[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
//      new Menu().showEmployeesByCompany();
//      new Menu().showAllEmployes();
    }
}
