package hw6.notes.service;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.hibernate.SessionFactory;
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

}
