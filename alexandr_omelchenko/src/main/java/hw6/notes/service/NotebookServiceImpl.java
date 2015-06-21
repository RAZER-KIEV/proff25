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

}
