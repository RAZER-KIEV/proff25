package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import java.util.List;

public interface NotebookDao {
    Long create(Notebook notebook);
    Notebook read(Long id);
    boolean update(Notebook notebook);
    boolean delete(Notebook notebook);
    List getNotebooksPorced(int start, int size);
    List findAll();
    List getNotebooksByCpuVendor(Vendor cpuVendor);
}
