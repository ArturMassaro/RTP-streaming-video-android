package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    AnchorPane apane;

    @FXML
    Label lArquivo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void close(MouseEvent mouseEvent) {

        String[] args = new String[] {"/bin/bash", "-c", "service WowzaStreamingEngine stop", "with", "args"};
        try {
            Process proc = new ProcessBuilder(args).start();
            System.out.println("server off");

            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void upload(MouseEvent mouseEvent) {



        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.MP4", "*.mp4"));
        fileChooser.setInitialDirectory(new File("/home/artur/Videos"));

        File file = fileChooser.showOpenDialog((Stage) apane.getScene().getWindow());

        if(file != null) {
            lArquivo.setText(file.getName().replace(".mp4", ""));


            String command = "cp " + file.getAbsolutePath() + " '/usr/local/WowzaStreamingEngine-4.7.7/content/'";


            String[] args = new String[]{"/bin/bash", "-c", command, "with", "args"};
            try {
                String[] args3 = new String[]{"/bin/bash", "-c", "rm '/usr/local/WowzaStreamingEngine-4.7.7/content/video.mp4'", "with", "args"};



                Process proc = new ProcessBuilder(args).start();
                System.out.println("set arquivo");


                command = "mv '/usr/local/WowzaStreamingEngine-4.7.7/content/'" + file.getName() + "    '/usr/local/WowzaStreamingEngine-4.7.7/content/video.mp4'";

                System.out.println("command = " + command);
                String[] args2 = new String[]{"/bin/bash", "-c", command, "with", "args"};

                proc = new ProcessBuilder(args2).start();

                //System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Nenhum arquivo selecionado");
        }



    }
}
