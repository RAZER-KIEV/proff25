package hw5.users;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by GFalcon on 10.06.15.
 * В класс UserJDBCManager поместите все операции с базой данных.
 * Желательно в методы этого класс передовать и возвращать
 * объекты класса User

 public int create(User user)
 public List<User> findAll()
 */
public class UserJDBCManager {
    private Connection conn;
    private List<User> userList;
    private Statement base;



    UserJDBCManager() throws SQLException {
        userList = new List<User>() {
            private ArrayList<User> ulist = new ArrayList<>();

            @Override
            public int size() {
                return ulist.size();
            }

            @Override
            public boolean isEmpty() {
                return ulist.isEmpty();
            }

            @Override
            public boolean contains(Object obj) {
                return ulist.contains(obj);
            }

            @Override
            public Iterator<User> iterator() {
                return ulist.iterator();
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(User user) {
                return ulist.add(user);
            }

            @Override
            public boolean remove(Object obj) {
                return ulist.remove(obj);
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends User> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends User> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {
                ulist.clear();
            }

            @Override
            public boolean equals(Object obj) {
                return ulist.equals(obj);
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public User get(int index) {
                return ulist.get(index);
            }

            @Override
            public User set(int index, User element) {
                return ulist.set(index, element);
            }

            @Override
            public void add(int index, User element) {
                ulist.add(index, element);
            }

            @Override
            public User remove(int index) {
                return ulist.remove(index);
            }

            @Override
            public int indexOf(Object obj) {
                return ulist.indexOf(obj);
            }

            @Override
            public int lastIndexOf(Object obj) {
                return ulist.lastIndexOf(obj);
            }

            @Override
            public ListIterator<User> listIterator() {
                return ulist.listIterator();
            }

            @Override
            public ListIterator<User> listIterator(int index) {
                return ulist.listIterator(index);
            }

            @Override
            public List<User> subList(int fromIndex, int toIndex) {
                return ulist.subList(fromIndex, toIndex);
            }
        };
        Locale.setDefault(Locale.ENGLISH);
    }
    public int create(User user) throws SQLException {
        String strQuery;
        base = getState();
        // ResultSet nextUId;
        //
        // SELECT USERS_SEQ.NEXTVAL FROM dual
        // SELECT USERS_SEQ.CURRVAL FROM dual

        ResultSet rs = base.executeQuery("SELECT * FROM users");
        long nextUserId = 1;
        rs.next();
        do {
            nextUserId++;
        } while (rs.next());

        /*
        base.executeUpdate("SELECT USERS_SEQ.NEXTVAL FROM dual");
        nextUId = base.getResultSet();
        long nextUserId = nextUId.getLong(1);
        */

        //long nextUserId = base.executeUpdate("SELECT USERS_SEQ.NEXTVAL FROM dual");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String df = dateFormat.format(user.getRegistrationDate());
        strQuery = "INSERT INTO users (user_id, user_name, password, r_date) VALUES (" + nextUserId + ", '" + user.getName() + "', '" + user.getPass() + "', TO_DATE('" + df + "'))";
      //  strQuery = "INSERT INTO hw5 (user_id, user_name, password, r_date) VALUES (" + user.getUserId() + ", '" + user.getName() + "', '" + user.getPass() + "', TO_DATE('" + df + "'))";
      //  strQuery = "INSERT INTO hw5 (user_id, user_name, password, r_date) VALUES (SELECT USERS_SEQ.NEXTVAL FROM dual, '" + user.getName() + "', '" + user.getPass() + "', TO_DATE('" + df + "'))";
        System.out.println(strQuery);

        base.executeUpdate(strQuery);
        base.close();
        return 1;
    }
    public List<User> findAll() throws SQLException {
       // User userItem = new User();
        base = getState();
        ResultSet rs = base.executeQuery("SELECT * FROM users");
        System.out.println("start iteration");
        int i = 1;
        rs.next();
        do {
            System.out.println(" = iteration #" + i);
            /*
            userItem.setUserId(rs.getLong(1));
            userItem.setName(rs.getString(2));
            userItem.setPass(rs.getString(3));
            userItem.setRegistrationDate(rs.getDate(4));
            */
            long id = rs.getLong(1);
            String nm = rs.getString(2);
            String ps = rs.getString(3);
            Date dt = rs.getDate(4);

            User userItem = new User(id, nm, ps, dt);

            System.out.println("read user " + userItem.getName());
            userList.add(userItem);
            System.out.println("add user " + userItem.getName());

            i++;
        } while (rs.next());
        base.close();
        return userList;
    }

    private Statement getState() throws SQLException {
        conn = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE","HR","HR");
        return conn.createStatement();
    }

    public void close() throws SQLException {
        base.close();
    }
}
