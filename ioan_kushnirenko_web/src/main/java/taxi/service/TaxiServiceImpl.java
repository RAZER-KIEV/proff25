package taxi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taxi.dao.TaxiDaoImpl;

import java.util.List;


/**
 * Created by ivan on 14.07.15.
 */
@Service
@Transactional
public class TaxiServiceImpl implements TaxiService {

    @Autowired
    private TaxiDaoImpl taxiDao;


    @Override
    public List showAll() {
        return taxiDao.findAll();
    }

}
