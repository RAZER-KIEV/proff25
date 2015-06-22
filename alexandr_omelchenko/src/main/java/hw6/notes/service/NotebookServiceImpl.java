package hw6.notes.service;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;
/**

 */
public class NotebookServiceImpl implements NotebookService {
private NotebookDaoImpl noteDAO;

    NotebookServiceImpl(){
        noteDAO = new NotebookDaoImpl();}
    NotebookServiceImpl(SessionFactory factory){
        noteDAO = new NotebookDaoImpl(factory);}
    @Override
    public Long add(Notebook notebook) {
        return  noteDAO.create(notebook);
    }
    @Override
    public List findAll() {
        return noteDAO.findAll();}

    @Override
    public void changePrice(Long id, double price) {
        Notebook note = noteDAO.read(id);
        note.setPrice(price);
        noteDAO.update(note);
    }

    @Override
    public void changeSerialVendor(Long id, String serial, String vendor) {
        Notebook note = noteDAO.read(id);
        note.setSerial(serial);
        note.setVendor(vendor);
        noteDAO.update(note);
    }

    @Override
    public boolean delete(Long id) {
        Notebook note = noteDAO.read(id);
        noteDAO.delete(note);
        return false;
    }

    @Override
    public boolean deleteByModel(String model) {
        boolean rez=false;
        List<Notebook> list =noteDAO.findByModel(model);
        for(Notebook nbk: list ){
            noteDAO.delete(nbk); rez=true;}
        return true;
    }

    @Override
    public List findByVendor(String vendor) {
        List<Notebook>list =noteDAO.findByVendor(vendor);
        return list;
    }
    @Override
    public List findByPriceManufDate(Double price, Date date) {
        List<Notebook>list = noteDAO.findByPriceManufDate(price, date);
        return null;
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        List<Notebook>list=noteDAO.findBetweenPriceLtDateByVendor(priceFrom, priceTo, date, vendor);
        return list;
    }
}