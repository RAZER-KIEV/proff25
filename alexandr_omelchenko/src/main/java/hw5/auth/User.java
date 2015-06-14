package hw5.auth;
import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private Date date;
    public Date getDate() {
        return date;}
    public void setDate(Date date) {
        this.date = date;}
    public String getName() {
        return name;}
    public void setName(String name) {
        this.name = name;}
    public String getPassword() {
        return password;}
    public void setPassword(String password) {
        this.password = password;}
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}

    public User(){
        name="defoult";
        password="defoult";
        date = Date.valueOf("2015-6-14");}
    public User(int i){
        this.id=i;
        name="defoult";
        password="defoult";
        date = Date.valueOf("2015-6-14");}
    public User(int id, String n, String pass){
        this.id=id;
        name=n;
        password=pass;
        date = Date.valueOf("2015-6-14");}
    public User(int id, String n, String pass, Date date){
        this.id=id;
        name=n;
        password=pass;
        this.date = date;}


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
