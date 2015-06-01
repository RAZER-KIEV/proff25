package homeTasks.week2;

import java.util.Date;

/**
 Написать модульные тесты для класса пользователь, на методы equals и hashCode.
 Поля класса пользователь:
 1. Логин
 2. Пароль
 3. Дата регистрации
 4. Рейтинг (вещественное число)
 5. Пол
 Класс задания hw2.hash.User
 */
public class UserTest {
    class User {
        public String getLogin() {
            return login;
        }
        public void setLogin(String login) {
            this.login = login;
        }
        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = key;
        }
        public Date getRegistration() {
            return registration;
        }
        public void setRegistration(Date registration) {
            this.registration = registration;
        }
        public double getRate() {
            return rate;
        }
        public void setRate(double rate) {
            this.rate = rate;
        }
        public String getMale() {
            return male;
        }
        public void setMale(String male) {
            this.male = male;
        }

        private String login;
        private String key;
        private Date registration;
        private double rate;
        private String male;

        void User(String l, String k, Date reg, double r, String m) {
            login = l;
            key = k;
            registration = reg;
            rate = r;
            male = m;
        }
        @Override
        public boolean equals( Object obj) {
            if(obj==null){return false;}
            if(obj==this){return true;}
            if(obj.getClass()!=getClass()){return false;}
            User user = (User) obj;
            if (this.login.equals(user.login)&&this.key.equals(user.key)&&
                    (this.registration ==user.registration)&&
                    this.rate==user.rate&&this.male.equals(user.male)){
                return true;
            }
            else return false;
        }
        @Override
        public int hashCode() {
            int hashU = login.hashCode()+key.hashCode()+registration.hashCode()+(int)rate+male.hashCode();
            return hashU;
        }
    }
}
