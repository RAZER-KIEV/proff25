package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/*
 *
 */
public interface NotebookDao {

    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List<Notebook> findAll();
    List<Notebook> findChunk(int startPoint, int chunkSize);
    Long getCount();
}
