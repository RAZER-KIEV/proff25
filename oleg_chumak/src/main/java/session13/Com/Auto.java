package session13.Com;

/**
 * Created by oleg on 29.06.15.
 */
public class Auto {
    private String mark;

    public Auto() {
    }

    public Auto(String mark) {

        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "mark='" + mark + '\'' +
                '}';
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
