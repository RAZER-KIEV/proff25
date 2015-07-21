package comandWork.dao;

import java.util.List;

//package Taxi.Dao;


import comandWork.domain.Taxi;
import org.springframework.expression.spel.ast.Operator;

import java.util.List;

/**
 * Created by jul on 14.07.2015.
 */
public interface TaxiDao {
    Long create(Taxi taxi);
    Taxi read(Long id);
    boolean update(Taxi taxi);
    boolean delete(Taxi taxi);
    List findAll();
}

