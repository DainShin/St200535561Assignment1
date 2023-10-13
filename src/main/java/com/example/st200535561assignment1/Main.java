package com.example.st200535561assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    /**
     * This method starts JavaFX UI
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("chart-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("US Unemployment Rate");
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("images/flag.jpg"))); // This is for the icon on the window
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This main method will call the launch method which calls start method
     */
    public static void main(String[] args) {
        launch();
    }

}
