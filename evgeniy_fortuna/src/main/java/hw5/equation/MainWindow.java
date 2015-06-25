package hw5.equation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Пользователь вводит диапазоны коэффициентов. Заполнить таблицу решениями квадратного уравнения с действительными решениями.
 * Дискретность шага перебора коэфициентов возьмите 1. Если кол-во решений больше 10000, то выводить "Слишком большой диапазон".
 * Структура таблицы (id, коэф_а, коэф_б, коэф_с, рез_1, рез_2)
 * Классы задания:
 * hw5.equation.MainWindow
 * hw5.equation.SolutionJDBCManager
 * hw5.equation.Solution
 * hw5.equation.QuadraticService
 *
 * В класс SolutionJDBCManager поместите все операции с базой данных. Желательно в методы этого класс передовать и возвращать объекты класса Solution
 *
 * public int create(Solution solution)
 * public List<Solution> findAll()
 *
 * В класс QuadraticService поместите всю логику вашего приложения по решению квадратного уравнения.
 *
 * public void solve(int fromA, int toA, int fromB, int toB, int fromC, int toC)
 */

public class MainWindow extends Application{
    public static void main(String[] args) {
        MainWindow.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane p = FXMLLoader.load(getClass().getResource("equation.fxml"));
        primaryStage.setScene(new Scene(p));
        primaryStage.show();
    }
}

