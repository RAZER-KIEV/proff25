package session13;

/**
 * Created by Sveta on 6/29/2015.
 */
public class Car {
    private String model;
    private Manager manager;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
    @Override
    public String toString() {
        return "Model: " + getModel() + ";      Manager: " + getManager();
    }
}
