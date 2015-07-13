package session13.Task1.service;


import session13.Task1.dao.CarDaoImpl;
import session13.Task1.dao.CompanyDaoImpl;
import session13.Task1.dao.DirectorDaoImp;
import session13.Task1.domain.Car;
import session13.Task1.domain.Company;
import session13.Task1.domain.Director;
import java.util.List;

/**
 * Created by ivan on 30.06.15.
 */
public class Loader {

    public static void main(String[] args) {
 //       new DirectorDaoImp().create(new Director("Stefanchik"));
 //        new CarDaoImpl().create(new Car("Deawoo",new DirectorDaoImp().read(4L)));
 //       new CompanyDaoImpl().create(new Company("itCentre", 100.40, new DirectorDaoImp().read(4L),new CarDaoImpl().read(5L)));
        List<Company> companies = new CompanyDaoImpl().findAll();
        for (Company c : companies){
            System.out.println(c);
        }
    }

}
