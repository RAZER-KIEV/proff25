package classwork.dao;

import classwork.domen.Taxist;

import java.util.List;

/**
 * Created by Well on 14.07.2015.
 */
public interface TaxistDao {

    Long create(Taxist tax);
    Taxist  read(Long id);
    boolean update(Taxist tax);
    boolean delete(Taxist tat);
    List<Taxist> findAll();

}
