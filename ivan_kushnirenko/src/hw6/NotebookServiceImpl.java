package hw6;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * Created by ivan on 17.06.15.
 */
public class NotebookServiceImpl implements  NotebookService{

    private static  Logger log = Logger.getLogger(NotebookServiceImpl.class);
    private NotebookDaoImpl nbDaoImpl;

    public Long addNotebook(Long serial, String vendor, String model,
                            Date manufactureDate, Integer price) {
        checkNotebookDaoImpl();
        if (model==null || vendor==null || price==null || manufactureDate==null){
            System.out.println("ERROR: fields model, vendor, price, manufactureDate must be non null.");
            return null;
        }
            return  nbDaoImpl.create(new Notebook(serial, vendor, model, manufactureDate, price));
    }

    public List<Notebook> showAllNotebooks(){
        checkNotebookDaoImpl();
        return nbDaoImpl.findAll();
    }

    @Override
    public String dellById(Long id) {
        checkNotebookDaoImpl();
        if (id==null){
            return "ERROR: Parametr id must be non-null.";
        }
        try {
            Notebook ntb = new Notebook();
            ntb.setId(id);
            if (nbDaoImpl.delete(ntb)==true){
                return "Success, notebook with id "+id+" was deleted.";
            }
            return "Operation 'delete notebook by id' cant be executed.";
        } catch (NullPointerException e){
            return "ERROR: Cannot find object with id: "+id+".";
        } catch (Exception e){
            return "ERROR. Cannot delete by id: "+id+", operation failed.";
        }
    }

    @Override
    public String setPriceById(Long id, Integer price) {
        checkNotebookDaoImpl();
        try {
            Notebook ntb = nbDaoImpl.read(id);
            ntb.setPrice(price);
            boolean res =  nbDaoImpl.update(ntb);
            if (res==true) {
                return "Success, parametr price for notebook with id " + id + " was set by " + price + ".";
            }
            return "ERROR: operation 'set price' by id "+id+" can not be executed.";
        } catch (NullPointerException e){
            return "ERROR: ID and price must be correct.";
        } catch (Exception e) {
            return "ERORR: Cannot set price by id: "+id+".";
        }
    }

    @Override
    public String setSerialAndVendorById (Long id, Long serial, String vendor) {
        checkNotebookDaoImpl();
        try {
            Notebook ntb = nbDaoImpl.read(id);
            ntb.setSerial(serial);
            ntb.setVendor(vendor);
            if (nbDaoImpl.update(ntb)==true) {
                return "Success, parametrs serial and vendor for notebook with id " + id + " was set by "
                        +serial+" and "+vendor+".";
            }
            return "ERROR: Operation 'set serial and vendor by id' can not be execured.";
        } catch (NullPointerException e){
            return "ERROR: Cannot find object with id: "+id+".";
        } catch (Exception e) {
            return "ERROR: Cannot set serial and vendor by id: "+id+".";
        }
    }

    @Override
    public String dellByModel(String model) { //
        checkNotebookDaoImpl();
        if (model==null || model.length()==0){
            return "ERROR: String model must be non-empty and non-null.";
        }
        int res = nbDaoImpl.deleteByModel(model);
        if (res==0){
            return "There no such notebooks.";
        } else if (res<0){
            return "ERROR: Operation 'delete notebook by model' can not be executed.";
        }
            return "Success: "+res+" items was deleted.";
    }

    @Override
    public List<Notebook> getByVendor(String vendor) {
        checkNotebookDaoImpl();
        List<Notebook> notebooks = nbDaoImpl.readByVendor(vendor);
        return notebooks;
    }

    @Override
    public List<Notebook> getByPriceAndDate(Integer price, Date date) {
        checkNotebookDaoImpl();
        List<Notebook> notebooks = nbDaoImpl.readByPriceAndDate(price, date);
        return notebooks;
    }

    @Override
    public List<Notebook> getByPriceWithVendorAndDate() {
//        checkNotebookDaoImpl();
//        List<Notebook> notebooks = nbDaoImpl.readByPriceAndDate();
        return null;
    }


    public static void main(String[] args) throws Exception{
        NotebookServiceImpl notebookService = new NotebookServiceImpl();
//      notebookService.printNotebooks(notebookService.showAllNotebooks());
//      System.out.println(notebookService.addNotebook(67838344L, "LENOVO_SHOP", "LENOVO", new Date(),new Integer(515)));
        System.out.println(notebookService.getByVendor("DELL_Shop"));
    }

    private void printNotebooks(List<Notebook> notebooks){
        for (Notebook ntb : notebooks) {
            System.out.println(ntb);
        }
    }

    private void checkNotebookDaoImpl(){
        if (nbDaoImpl==null){
            nbDaoImpl = new NotebookDaoImpl();
        }
    }
}
