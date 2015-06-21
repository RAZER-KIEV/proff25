package hw6.notes.service;

import hw6.notes.domain.Notebook;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
import java.util.Date;
import java.util.List;

public class NotebookServiceImpl implements NotebookService {
    private NotebookDaoImpl notebookDao;

    public NotebookServiceImpl(){
    }

    public NotebookServiceImpl(SessionFactory factory) {
        notebookDao = new NotebookDaoImpl(factory);
    }

    public void createDao(SessionFactory factory) {
        notebookDao = new NotebookDaoImpl(factory);
    }

    @Override
    public Long add(Notebook notebook) {
        return notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll() {
        return notebookDao.findAll();
    }

    @Override
    public void changePrice(Long id, double price) {
        Notebook notebook = notebookDao.read(id);
        notebook.setPrice(price);
        notebookDao.update(notebook);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook notebook = notebookDao.read(id);
        notebook.setSerial(serial);
        notebook.setVendor(vendor);
        notebookDao.update(notebook);
    }

    @Override
    public boolean delete(Long id) {
        Notebook notebook = notebookDao.read(id);
        return notebookDao.delete(notebook);
    }

    @Override
    public boolean deleteByModel(String model) {
        List<Notebook> notebooks = notebookDao.findByModel(model);
        boolean result = true;
        for(Notebook notebook:notebooks){
            result = result && notebookDao.delete(notebook);
        }
        return result;
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        return notebookDao.findByVendor(vendor);
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        return notebookDao.findByPriceManufDate(price,date);
    }

    @Override
    public List<Notebook> findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return notebookDao.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendor);
    }
}
