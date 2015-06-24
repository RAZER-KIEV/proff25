package hw7.notes;

import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.createSessionFactory();
        SessionFactory sessionFactory = hibernateUtil.getFactory();

        sessionFactory.close();
    }
}
