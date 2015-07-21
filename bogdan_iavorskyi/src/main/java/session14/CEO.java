package session14;

/**
 * Created by bosyi on 29.06.15.
 */
public class CEO {
    private String name;

    public CEO() {
    }

    public CEO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CEO{" +
                "name='" + name + '\'' +
                '}';
    }
}
