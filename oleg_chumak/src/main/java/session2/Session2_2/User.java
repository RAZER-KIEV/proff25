package session2.Session2_2;

/**
 * Created by oleg on 19.05.15.
 */
 class User implements Comparable{
    private String name;
    private String password;
    private int timeToCancel;
    public User(String name, String password, int timeToCancel){
        this.name = name;
        this.password = password;
        this.timeToCancel = timeToCancel;
    }
    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public int hashCode() {
        return password.hashCode() + name.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        }
        User tmp = (User)obj;
        return (name.equals(tmp.name) && password.equals(tmp.password));
    }

    @Override
    public int compareTo(Object user) {
        User tmp = (User) user;
        return timeToCancel - tmp.timeToCancel;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString(){
        return name + " " +timeToCancel;
    }
}