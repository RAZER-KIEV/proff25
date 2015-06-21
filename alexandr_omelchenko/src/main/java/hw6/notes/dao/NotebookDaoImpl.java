package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
 public static void main(String[] args) {
  NotebookDaoImpl note = new NotebookDaoImpl();
  note.initialize();
  //note.create(new Notebook());
  List list =note.findAll();
  System.out.println(list.toString());
 // Session session = note.factory.openSession();
  //Notebook noteb = (Notebook) session.get(Notebook.class, 5L);
  //session.close();
  //noteb.setModel("pavilion");
//note.update(noteb);
  //note.delete(noteb);
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
 public void initialize(){
  Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
  StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
  sb.applySettings(cfg.getProperties());
  StandardServiceRegistry standardServiceRegistry = sb.build();
  factory = cfg.buildSessionFactory(standardServiceRegistry);
  log.info("Reference to SessionFactory " + factory);
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
  list =session.createQuery("from hw6.notes.domain.Notebook").list();
  return list;
 }
}
