package hw6.notes.service;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Jeckgehor on 20.06.2015.
 */
public class NotebookServiceImpl implements NotebookService {
    @Override
    public Long add(Notebook notebook) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(HibernateUtil.connect());
        Long idx = notebookDao.create(notebook);
        HibernateUtil.closeFactory();
        return idx;
    }

    @Override
    public List<Notebook> findAll() {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(HibernateUtil.connect());
        List<Notebook> list = notebookDao.findAll();
        HibernateUtil.closeFactory();
        return list;
    }

    @Override
    public void changePrice(Long id, double price) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(HibernateUtil.connect());
        Notebook ntb = notebookDao.read(id);
        ntb.setPrice(price);
        notebookDao.update(ntb);
        HibernateUtil.closeFactory();
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(HibernateUtil.connect());
        Notebook ntb = notebookDao.read(id);
        ntb.setSerial(serial);
        ntb.setVendor(vendor);
        notebookDao.update(ntb);
        HibernateUtil.closeFactory();
    }

    @Override
    public boolean delete(Long id) {
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(HibernateUtil.connect());
        Notebook ntb = notebookDao.read(id);
        notebookDao.delete(ntb);
        HibernateUtil.closeFactory();
        return false;
    }

    @Override
    public boolean deleteByModel(String model) {
        return false;
    }

    @Override
    public List findByVendor(String vendor) {
        return null;
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return null;
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
