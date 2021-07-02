import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class LearnController {


    @FXML
    public GridPane grid;





    public static void fillFormLearn(String fill) {
        char[] chars = fill.toCharArray();

        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (chars[count] == '1') {
                    Image image = new Image("whitecell.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(20);
                    pic.setFitHeight(20);
                    pic.setImage(image);
                    GridPane.setHalignment(pic, HPos.CENTER);
                    GridPane.setValignment(pic, VPos.CENTER);
                    Learn.learnControllerHandler.grid.add(pic, i, j);
                }
                if (chars[count] == '2') {
                    Image image = new Image("blackcell.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(20);
                    pic.setFitHeight(20);
                    pic.setImage(image);
                    GridPane.setHalignment(pic, HPos.CENTER);
                    GridPane.setValignment(pic, VPos.CENTER);
                    Learn.learnControllerHandler.grid.add(pic, i, j);
                }
                if (chars[count] == '0') {
                    Image image = new Image("emptycell.png");
                    ImageView pic = new ImageView();
                    pic.setFitWidth(20);
                    pic.setFitHeight(20);
                    pic.setImage(image);
                    GridPane.setHalignment(pic, HPos.CENTER);
                    GridPane.setValignment(pic, VPos.CENTER);
                    Learn.learnControllerHandler.grid.add(pic, i, j);
                }

                count++;
            }

        }


    }


    public void putstone(MouseEvent e) {
        for (Node node : grid.getChildren()) {
            node.setOnMouseClicked((MouseEvent t) -> {
                Integer colIndex = GridPane.getColumnIndex(node);
                Integer rowIndex = GridPane.getRowIndex(node);
                System.out.println(colIndex.intValue()+"  "+ rowIndex.intValue());
                try {

                    PrintWriter outMessage= new PrintWriter(MyControllerHandler.socket.getOutputStream());
                    outMessage.println("##position##"+colIndex.intValue()+"##"+rowIndex.intValue()+"##");
                    outMessage.flush();
                }
                catch (Exception exp){
                    exp.getMessage();
                }

            });

        }


    }
}