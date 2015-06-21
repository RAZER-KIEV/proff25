package hw6.notes.dao;

import hw6.notes.domain.Notebook;

import java.util.List;

/**
 * Created by viktoria
 * Project:.hw6.notes.dao
 * Создать DAO для таблицы ноутбуки
 * Таблица ноутбуки имеет следующую структуру (id, serial, vendor, model, manufacture date, price)
 * domain   hw6.notes.domain.Notebook
 * dao      hw6.notes.dao.NotebookDao
 * Long create(Notebook ntb), Notebook read(Long ig), boolean update(Notebook ntb), boolean delete(Notebook ntb), List findAll()
 * hw6.notes.dao.NotebookDaoImpl
 *
 */
public interface NotebookDao {
    Long create(Notebook ntb);
    Notebook read(Long id);
    boolean update(Notebook ntb);
    boolean delete(Notebook ntb);
    List<Notebook> findAll();
}
