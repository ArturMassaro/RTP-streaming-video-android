package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //sem sudo

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        String[] args = new String[] {"/bin/bash", "-c", "service WowzaStreamingEngine start", "with", "args"};
        Process proc = new ProcessBuilder(args).start();

        System.out.println("server on");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
