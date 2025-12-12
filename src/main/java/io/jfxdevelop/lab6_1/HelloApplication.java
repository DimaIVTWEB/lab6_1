package io.jfxdevelop.lab6_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private HelloController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Поиск студентов");
        stage.setScene(scene);
        stage.show();

        controller = fxmlLoader.getController();
    }

    @Override
    public void stop() {
        // Вызываем метод закрытия соединения при выходе из приложения
        if (controller != null) {
            controller.shutdown();
        }
    }
}