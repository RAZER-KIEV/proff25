package hw5.finder;

import java.util.Date;

/**
 * Created by oleg on 11.06.15.
 */
public class Path {
    private int id;
    private java.util.Date date;
    private String filePath;
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getFilePath() {
        return filePath;
    }

    public Path(int id, Date date, String filePath) {
        this.id = id;
        this.date = date;
        this.filePath = filePath;
    }
}
