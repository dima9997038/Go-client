import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;


public class MyControllerHandler {

    @FXML
    public ResourceBundle resources;

    @FXML
    public URL location;


    @FXML
    public Button start;

    @FXML
    public Button learn;

    @FXML
    public Button rules;

    @FXML
    public Button exit;

 //   public static volatile MyControllerHandler learnControlerHandler;
    public static Socket socket;

    public void starting(ActionEvent actionEvent) {
         socket = MainApp.getCurrentClient().getClientSocket();
        try {

            PrintWriter outMessage= new PrintWriter(socket.getOutputStream());
            outMessage.println("##game##1##");
            outMessage.flush();
        }
        catch (Exception e){
            e.getMessage();
        }
        Learn learn = new Learn(actionEvent);
    }

    public void learning(ActionEvent actionEvent) {

        socket = MainApp.getCurrentClient().getClientSocket();
        try {

            PrintWriter outMessage= new PrintWriter(socket.getOutputStream());
            outMessage.println("##learn##1##");
            outMessage.flush();
        }
        catch (Exception e){
            e.getMessage();
        }

        Learn learn = new Learn(actionEvent);


    }

    public void showRules(ActionEvent actionEvent) {
    }

    public void toexit(ActionEvent actionEvent) {
    }


}


