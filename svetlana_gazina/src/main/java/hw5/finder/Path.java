package hw5.finder;

import java.util.Date;

/**
 * Created by Sveta on 6/13/2015.
 */
public class Path {

    private String path;
    private Date date;

    public Path() {
    }

    public Path(String path, Date date) {

        this.path = path;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



}
