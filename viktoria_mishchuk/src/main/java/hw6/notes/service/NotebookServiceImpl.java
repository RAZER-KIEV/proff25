package hw6.notes.service;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw6.notes.service
 */
public class NotebookServiceImpl implements NotebookService{
    private static Logger log = Logger.getLogger(NotebookService.class);
    private SessionFactory factory;
    NotebookDaoImpl notebookDao;

    public NotebookServiceImpl(){

    }

    public NotebookServiceImpl (SessionFactory factory){
        notebookDao = new NotebookDaoImpl(factory);
    }

    @Override
    public Long add(Notebook notebook){
        return (Long)notebookDao.create(notebook);
    }

    @Override
    public List<Notebook> findAll(){
        return notebookDao.findAll();
    }
}
