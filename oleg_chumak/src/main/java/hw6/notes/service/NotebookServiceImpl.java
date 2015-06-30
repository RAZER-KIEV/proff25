package hw6.notes.service;

import hw6.notes.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by oleg on 17.06.15.
 */
public class NotebookServiceImpl implements NotebookService {

    private SessionFactory factory;
    NotebookDaoImpl dao;

    public NotebookServiceImpl() {
        dao = new NotebookDaoImpl();
        factory = dao.getFactory();
    }

    @Override
    public Long add(Notebook notebook) {
        return dao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return dao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook note = dao.read(id);
        note.setPrice(price);
        dao.update(note);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook note = dao.read(id);
        note.setVendor(vendor);
        note.setSerial(serial);
        dao.update(note);
    }

    @Override
    public boolean delete(Long id) {
        return    dao.delete(dao.read(id));
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> list = dao.findByModel(model);
        try {
            for (Notebook note : list) {
                dao.delete(note);
            }
        }catch (HibernateException except){
            return false;
        }
        return true;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return dao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return dao.findByPriceManufDate(price, date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return dao.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }
}
