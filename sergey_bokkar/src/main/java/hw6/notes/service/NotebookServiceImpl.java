package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Well on 17.06.2015.
 */
public class NotebookServiceImpl implements NotebookService {

    private NotebookDaoImpl ndi;

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
}
