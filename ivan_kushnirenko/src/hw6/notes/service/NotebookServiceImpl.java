package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Date;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 * Created by ivan on 17.06.15.
 */
public class NotebookServiceImpl implements NotebookService {

    private static  Logger log = Logger.getLogger(NotebookServiceImpl.class);
    private NotebookDaoImpl nbDaoImpl;

    public NotebookDaoImpl getNbDaoImpl() {
        return nbDaoImpl;
    }
    public void setNbDaoImpl(NotebookDaoImpl nbDaoImpl) {
        this.nbDaoImpl = nbDaoImpl;
    }

    @Override
    public Long add(Notebook notebook) {
        checkNotebookDaoImpl();
        return  nbDaoImpl.create(notebook);
    }
    @Override
    public List findAll(){
        checkNotebookDaoImpl();
        return nbDaoImpl.findAll();
    }
    @Override
    public void changePrice(Long id, double price) {
        checkNotebookDaoImpl();
        try {
            Notebook ntb = nbDaoImpl.read(id);
            ntb.setPrice(price);
            boolean res =  nbDaoImpl.update(ntb);
            if (res==true) {
                System.out.println("Success, parametr price for notebook with id " + id + " was set by " + price + ".");
            }
            System.out.println("ERROR: operation 'set price' by id "+id+" can not be executed.");
        } catch (NullPointerException e){
            System.out.println("ERROR: ID and price must be correct.");
        } catch (Exception e) {
            System.out.println("ERORR: Cannot set price by id: "+id+".");
        }
    }
    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        checkNotebookDaoImpl();
        try {
            Notebook ntb = nbDaoImpl.read(id);
            ntb.setSerial(serial);
            ntb.setVendor(vendor);
            if (nbDaoImpl.update(ntb) == true) {
                System.out.println("Success, parametrs serial and vendor for notebook with id " + id + " was set by "
                        +serial+" and "+vendor+".");
            }
            System.out.println("ERROR: Operation 'set serial and vendor by id' can not be execured.");
        } catch (NullPointerException e){
            System.out.println("ERROR: Cannot find object with id: "+id+".");
        } catch (Exception e) {
            System.out.println("ERROR: Cannot set serial and vendor by id: "+id+".");
        }
    }
    @Override
    public boolean delete(Long id) {
        checkNotebookDaoImpl();
        if (id==null){
            System.out.println("ERROR: Parametr id must be non-null.");
            return false;
        }
        try {
            Notebook ntb = new Notebook();
            ntb.setId(id);
            if (nbDaoImpl.delete(ntb) == true){
                System.out.println("Success, notebook with id "+id+" was deleted.");
                return true;
            }
            System.out.println("Operation 'delete notebook by id' cant be executed.");
            return false;
        } catch (NullPointerException e){
            System.out.println("ERROR: Cannot find object with id: "+id+".");
            return false;
        } catch (Exception e){
            System.out.println("ERROR. Cannot delete by id: "+id+", operation failed.");
            return false;
        }
    }
    @Override
    public boolean deleteByModel(String model) { //
        checkNotebookDaoImpl();
        if (model==null || model.length()==0){
            System.out.println("ERROR: String model must be non-empty and non-null.");
            return false;
        }
        List<Notebook> notebooks = nbDaoImpl.findByModel(model);
        for (Notebook ntb : notebooks) {
            nbDaoImpl.delete(ntb);
        }
        if (notebooks.size()==0){
            System.out.println("There no such notebooks.");
            return false;
        }
        System.out.println("Success: "+notebooks.size()+" items was deleted.");
        return true;
    }
    @Override
    public List findByVendor(String vendor) {
        checkNotebookDaoImpl();
        List<Notebook> notebooks = nbDaoImpl.findByVendor(vendor);
        return notebooks;
    }
    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        checkNotebookDaoImpl();
        List<Notebook> notebooks = nbDaoImpl.findByPriceManufDate(price, date);
        return notebooks;
    }
    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor){
        checkNotebookDaoImpl();
        List<Notebook> notebooks = nbDaoImpl.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
        return notebooks;
    }

    public static void main(String[] args) throws Exception{

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
