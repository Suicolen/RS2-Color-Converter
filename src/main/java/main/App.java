package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/scene.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(this.getClass().getResource("/css/darktheme.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("RS Color Picker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
