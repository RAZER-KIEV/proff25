package session13.comp_dir;

/**
 * Created by RAZER on 29.06.2015.
 */
public class Car {
    private Company company;
    private Director director;

    public Car(){}

    public Car(Director director) {
        this.director = director;
    }

    public Car(Company company) {

        this.company = company;
    }

    public Car(Company company, Director director) {
        this.company = company;
        this.director = director;

    }

    public Company getCompany() {
        return company;
    }

    public Director getDirector() {
        return director;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}


