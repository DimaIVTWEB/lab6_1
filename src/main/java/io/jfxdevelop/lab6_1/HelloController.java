package io.jfxdevelop.lab6_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.List;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField searchField; // Поле для ввода имени

    @FXML
    private Button searchButton; // Кнопка поиска

    @FXML
    private ListView<String> resultsListView; // Список для отображения результатов

    private DatabaseManager dbManager;

    // Инициализация контроллера
    @FXML
    public void initialize() {
        // Инициализируем менеджер базы данных
        dbManager = new DatabaseManager();

        // Настройка кнопки поиска
        searchButton.setOnAction(event -> handleSearch());
    }

    // Обработчик поиска
    private void handleSearch() {
        String searchText = searchField.getText().trim();
        if (searchText.isEmpty()) {
            resultsListView.getItems().clear();
            resultsListView.getItems().add("Введите имя для поиска.");
            return;
        }

        List<Student> foundStudents = dbManager.searchStudentsByName(searchText);

        // Очищаем список результатов
        resultsListView.getItems().clear();

        if (foundStudents.isEmpty()) {
            resultsListView.getItems().add("Студенты не найдены.");
        } else {
            for (Student student : foundStudents) {
                resultsListView.getItems().add(student.toString());
            }
        }
    }

    // Метод для закрытия соединения при выходе из приложения
    public void shutdown() {
        if (dbManager != null) {
            dbManager.closeConnection();
        }
    }
}