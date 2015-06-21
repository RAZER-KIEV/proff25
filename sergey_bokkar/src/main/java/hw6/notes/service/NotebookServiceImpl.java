package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;

import java.util.Date;
import java.util.List;

/**
 * Created by Well on 17.06.2015.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDaoImpl ndi;

    public NotebookServiceImpl () {
        this.ndi = new NotebookDaoImpl();
    }

    public NotebookServiceImpl(NotebookDaoImpl ndi){
        this.ndi = ndi;
    }

    @Override
    public Long add(Notebook notebook) {
        return ndi.create(notebook);
    }

    @Override
    public List findAll() {
        return ndi.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook ntb = ndi.read(id);
        ntb.setPrice(price);
        ndi.update(ntb);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook ntb = ndi.read(id);
        ntb.setSerial(serial);
        ntb.setVendor(vendor);
        ndi.update(ntb);

    }

    @Override
    public boolean delete(Long id) {
        Notebook ntb = ndi.read(id);
        if (ntb != null) {
            ndi.delete(ntb);
            return true;
        }
         return false;
    }

    @Override
    public boolean deleteByModel(String model) {
       if (model != null) {List<Notebook> ntbList = ndi.findByModel(model);
        for(int i = 0; i < ntbList.size(); i++){
            Notebook ntb = ntbList.get(i);
            ndi.delete(ntb);
        }
           return true;
       }
        return false;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return ndi.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return ndi.findByPriceManufDate(price, date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return ndi.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }
}
