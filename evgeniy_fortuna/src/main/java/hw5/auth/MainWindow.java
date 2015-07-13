package hw5.auth;

import javax.swing.*;

public class MainWindow extends JDialog {
    private JPanel contentPane;


    public MainWindow() {
        setContentPane(contentPane);
        setModal(true);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) {
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

