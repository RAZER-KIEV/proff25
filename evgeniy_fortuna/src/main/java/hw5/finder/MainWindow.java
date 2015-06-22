package hw5.finder;

import javax.swing.*;
import java.awt.*;

/**
 * Написать приложение, осуществляющее поиск файла в файловой системе с сохранением результата в таблице базы данных.
 * Структура таблицы (id, дата, путь)
 *
 * Классы задания:
 * hw5.finder.MainWindow
 * hw5.finder.PathJDBCManager
 * hw5.finder.Path
 * hw5.finder.FileService
 */

public class MainWindow extends JFrame{

    MainWindow() {
        super("!");
        setGUI();
    }

    private void setGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 350, 420, 25);
        setResizable(false);

        JPanel find = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblDirectory = new JLabel("Directory: ");
        find.add(lblDirectory);
        JTextField fldDirectory = new JTextField();
        fldDirectory.setPreferredSize(new Dimension(100, 20));
        find.add(fldDirectory);
        JLabel lblFile = new JLabel("File: ");
        find.add(lblFile);
        JTextField fldFile = new JTextField();
        fldFile.setPreferredSize(new Dimension(100, 20));
        find.add(fldFile);
        JButton btnFind = new JButton("Find");
        btnFind.setPreferredSize(new Dimension(75, 20));
        btnFind.addActionListener(new FileService(fldFile, fldDirectory));
        find.add(btnFind);

        add(find, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow main = new MainWindow();
    }
}

