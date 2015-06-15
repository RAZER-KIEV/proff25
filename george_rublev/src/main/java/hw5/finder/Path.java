package hw5.finder;

/**
 *
 * Created by george on 11.06.15.
 */
public class Path {
    private int id;
    private String date;
    private String filePath;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getFilePath() {
        return filePath;
    }

    public Path(int id, String date, String filePath) {
        this.id = id;
        this.date = date;
        this.filePath = filePath;
    }
}
