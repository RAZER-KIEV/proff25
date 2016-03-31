package home.service;

import home.dao.NetworkDao;
import home.domain.Network;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by RAZER on 2/8/2016.
 */

@Service
@Transactional
public class NetworkServiceImpl implements NetworkService {

    @Autowired
    NetworkDao networkDao;

    @Autowired
    EventService eventService;

    @Override
    public Long create(Network network) {
        Long id = networkDao.create(network);
        eventService.createNewNetworkEv(networkDao.read(id));
        return id ;
    }

    @Override
    public Network read(Long id) {
        return networkDao.read(id);
    }

    @Override
    public boolean update(Network network) {
        return networkDao.update(network);
    }

    @Override
    public boolean delete(Network network) {
        return networkDao.delete(network);
    }

    @Override
    public List findAll() {
        return networkDao.findAll();
    }
}
