package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import oracle.sql.TIMESTAMP;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.management.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
 public static void main(String[] args) {
  NotebookDaoImpl note = new NotebookDaoImpl();
 note.initialize();
 note.create(new Notebook());
//Notebook noteB =note.read(24L);
  Date date =new Date(115, 0, 1);
  TIMESTAMP time = new TIMESTAMP();
 List list = note.findByPriceManufDate(900.99, date);
 // List lister = note.findBetweenPriceLtDateByVendor(900., 1000., date, "Ivan");
 // System.out.println(list.toString());
//  System.out.println(noteB.getDate());
  note.factory.close();
 }
 private SessionFactory factory;
 private static Logger log;

public NotebookDaoImpl(){
 factory=null;
 log = Logger.getLogger(NotebookDaoImpl.class);
}
 public NotebookDaoImpl(SessionFactory factory){
  this.factory=factory;
  log = Logger.getLogger(NotebookDaoImpl.class);
 }

 @Override
 public SessionFactory initialize(){
  Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
  StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
  sb.applySettings(cfg.getProperties());
  StandardServiceRegistry standardServiceRegistry = sb.build();
  factory = cfg.buildSessionFactory(standardServiceRegistry);
  log.info("Reference to SessionFactory " + factory);
 return factory;
 }
 @Override
 public Long create(Notebook ntb) {
  Session session = factory.openSession();
  Long id = null;
  try {
   session.beginTransaction();
   id = (Long)session.save(ntb);
   session.getTransaction().commit();
   return id;
  }catch (HibernateException e){
   log.error("Transaction failed");
   session.getTransaction().rollback();
  }finally {
   if (session!=null)
    session.close();
  }
  return id;
 }

 @Override
 public Notebook read(Long id) {
  Session session = factory.openSession();
  try{
   return (Notebook)session.get(Notebook.class,id);
  }catch (HibernateException e){
   log.error("Transaction failed");
   return null;
  }finally {
   if (session!=null)
    session.close();
  }
 }

 @Override
 public boolean update(Notebook ntb) {
  Session session = factory.openSession();
  try {
   session.beginTransaction();
   session.update(ntb);
   session.getTransaction().commit();
   return true;
  }catch (HibernateException e){
   log.error("Transaction failed");
   session.getTransaction().rollback();
   return false;
  }finally {
   if (session!=null)
    session.close();
  }
 }

 @Override
 public boolean delete(Notebook ntb) {
 Session session = factory.openSession();
  try{
   session.beginTransaction();
   session.delete(ntb);
   session.getTransaction().commit();
  }
  catch(HibernateException e){
   log.error("Transaction failed");
   session.getTransaction().rollback();
   return false;
  }finally {
   if (session!=null)
    session.close();
  }
  return false;
 }

 @Override
 public List findAll() {
  Session session = factory.openSession();
  List<Notebook>list = new ArrayList<>();
  list =session.createQuery("from Notebook").list();
  if (session!=null){
   session.close();}
  return list;
 }

 @Override
 public List findByModel(String model) {
  Session session = factory.openSession();
  List<Notebook>list = new ArrayList<>();
  list =session.createQuery("from Notebook n where n.model = '"+model+"'").list();
  if (session!=null){
   session.close();}
  return list;
 }
 @Override
 public List findByVendor(String vendor) {
  Session session = factory.openSession();
  List<Notebook>list = new ArrayList<>();
  list =session.createQuery("from Notebook n where n.vendor = '"+vendor+"'").list();
  if (session!=null){
   session.close();}
  return list;
 }
 //@Override
 public List findByPriceManufDate(Double price, Date date) {
  Session session = factory.openSession();
Date dat = new java.sql.Date(date.getTime());
  TIMESTAMP time = new TIMESTAMP();
  List<Notebook>list = new ArrayList<>();
  System.out.println("завис");
  list =session.createQuery("from Notebook n where n.price = '"+price+"' and n.manufacture_date = '"+time+"'").list();
  //select mo from MyObject mo where year(mo.date) = year(:date) and month(mo.date) = month(:date) and day(mo.date) = day(:date);
  if (session!=null){
   session.close();}
  System.out.println("розвис");
  return list;
 }
 //- Получить ноутбуки по цене в указанном диапазоне, меньше указанной даты выпуска и указанного производителя
 @Override
 public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
  Session session = factory.openSession();
  List<Notebook>list = new ArrayList<>();
  list =session.createQuery("from Notebook n where n.price between '"+priceFrom+"' and '"+priceTo+"' and n.manufacture_date = '"+date+"' " +
          "and n.vendor='"+vendor+"'").list();
  if (session!=null){
   session.close();}
  return list;
 }
}