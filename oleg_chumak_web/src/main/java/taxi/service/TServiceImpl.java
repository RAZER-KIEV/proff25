package taxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taxi.dao.*;
import taxi.domain.*;

import java.util.List;

/**
 * Created by oleg on 16.07.15.
 */
@Service
@Transactional
public class TServiceImpl implements TService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private TaxiDriverDao taxiDriverDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private OperatorDao operatorDao;
    @Autowired
    private RoleDao roleDao;

    public TServiceImpl() {

    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> clientsPortinedByTen(Long numberOfPortion) {
        return clientDao.clientsPortinedByTen(numberOfPortion);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> clientsMadeOrdersDuringLastMonth() {
        return clientDao.clientsMadeOrdersDuringLastMonth();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> clientswithOrderAmountMoreThen(Long amount) {
        return clientDao.clientswithOrderAmountMoreThen(amount);
    }

    @Override
    public Long createClient(Client client) {
        return clientDao.create(client);
    }

    @Transactional(readOnly = true)
    @Override
    public Client readClient(Long id) {
        return clientDao.read(id);
    }

    @Override
    public boolean updateClient(Client client) {
        return clientDao.update(client);
    }

    @Override
    public boolean deleteClient(Client client) {
        return clientDao.delete(client);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Client> findAllClients() {
        return clientDao.findAll();
    }

    @Override
    public String createOperator(Operator operator) {
        return operatorDao.create(operator);
    }

    @Transactional(readOnly = true)
    @Override
    public Operator readOperator(String login) {
        return operatorDao.read(login);
    }

    @Override
    public boolean updateOperator(Operator operator) {
        return operatorDao.update(operator);
    }

    @Override
    public boolean deleteOperator(Operator operator) {
        return operatorDao.delete(operator);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Operator> findAllOperators() {
        return operatorDao.findAll();
    }

    @Override
    public Long createOrder(Order order) {
        return orderDao.create(order);
    }

    @Transactional(readOnly = true)
    @Override
    public Order readOrder(Long id) {
        return orderDao.read(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.delete(order);
    }

    @Override
    public List listAllOrders() {
        return orderDao.listAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List listOfOrdersInRangeOfAmount(Long from, Long to) {
        return orderDao.listInRangeOfAmount(from, to);
    }

    @Transactional(readOnly = true)
    @Override
    public List listOfOrdersChunk(int startPoint, int chunkSize) {
        return orderDao.listChunk(startPoint, chunkSize);
    }

    @Override
    public String createRole(Role role) {
        return roleDao.create(role);
    }

    @Transactional(readOnly = true)
    @Override
    public Role readRole(String roleName) {
        return roleDao.read(roleName);
    }

    @Override
    public boolean updateRole(Role role) {
        return roleDao.update(role);
    }

    @Override
    public boolean deleteRole(Role role) {
        return roleDao.delete(role);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public TaxiDriver readTaxist(Long id) {
        return taxiDriverDao.read(id);
    }

    @Override
    public Long createTaxist(TaxiDriver taxiDriver) {
        return taxiDriverDao.create(taxiDriver);
    }

    @Override
    public boolean updateTaxist(TaxiDriver taxiDriver) {
        return taxiDriverDao.update(taxiDriver);
    }

    @Override
    public boolean deleteTaxist(TaxiDriver taxiDriver) {
        return taxiDriverDao.delete(taxiDriver);
    }

    @Transactional(readOnly = true)
    @Override
    public List findAllTaxists() {
        return taxiDriverDao.findAll();
    }
}
