package hw5.finder;


import java.util.Date;

/**
 * Created by ivan on 26.07.15.
 */
public class Path {

    private static Long countId = Long.valueOf(0);

    private Long id;
    private String path;
    private Date date;

    public Path() {
        this("/home/", new Date());
    }

    public Path(String path, Date date) {
        id = countId;
        this.path = path;
        this.date = date;
        countId++;
    }

    public static Long getCountId() {
        return countId;
    }

    public static void setCountId(Long countId) {
        Path.countId = countId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new String("id: "+id+"; path: "+path+"; creation date: "+date+".");
    }
}
