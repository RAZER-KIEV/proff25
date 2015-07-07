package session13.comp_dir;

/**
 * Created by RAZER on 29.06.2015.
 */
public class Director {
    private String name;
    private Company company;

    public Director(){}

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {

        return company;
    }

    public Director(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Dir.Name "+name+" Company headed "+company;
    }
}
