package hw5.auth;

/**
 * Created by ivan on 24.07.15.
 *
 */

public class MainWindow {

    private UserJDBCManager userJDBCManager;

    public UserJDBCManager getUserJDBCManager() {
        return userJDBCManager;
    }

    public void setUserJDBCManager(UserJDBCManager userJDBCManager) {
        this.userJDBCManager = userJDBCManager;
    }

    public MainWindow() {
        userJDBCManager = new UserJDBCManager();
    }

    public void authenticate(String login, String password) {
        User user = userJDBCManager.readByNamePass(login, password);
        if (user != null) {
            System.out.println("Success!");
            System.out.println(userJDBCManager.findAll());
        } else {
            System.out.println("ERROR: Authentication failed.");
        }
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.authenticate("User", "123");
    }
}
