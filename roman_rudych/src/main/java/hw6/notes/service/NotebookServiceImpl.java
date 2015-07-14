package hw6.notes.service;

import hw6.notes.domain.Notebook;
import hw6.notes.NotebookDaoImpl;
import hw6.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Роман on 21.06.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    private SessionFactory factory;
    private NotebookDaoImpl notebookDao;
    @Override
    public Long add(Notebook notebook) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        Long result = notebookDao.create(notebook);
//        factory.close();
        return result;
    }

    @Override
    public List findAll() {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        List result = notebookDao.findAll();
//        factory.close();
        return result;
    }

    @Override
    public void changePrice(Long id, double price) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        Notebook ntb = notebookDao.read(id);
        ntb.setPrice(price);
        notebookDao.update(ntb);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        Notebook ntb = notebookDao.read(id);
        ntb.setSerial(serial);
        ntb.setVendor(vendor);
        notebookDao.update(ntb);
    }

    @Override
    public boolean delete(Long id) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.delete(notebookDao.read(id));
    }

    @Override
    public boolean deleteByModel(String model) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        List<Notebook> list = notebookDao.findByModel(model);
        boolean result = false;
        for(Notebook ntb : list) {
            notebookDao.delete(ntb);
            result = true;
        }
        return result;
    }

    @Override
    public List findByVendor(String vendor) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.findByPriceManufDate(price, date);
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        factory = HibernateUtil.getSessionFactory();
        notebookDao = new NotebookDaoImpl(factory);
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
    }

    public SessionFactory getCurrentFactory() {
        return factory;
    }
}
