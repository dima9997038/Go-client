import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Learn {

    public static volatile LearnController learnControllerHandler;


    public Learn(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("learn.fxml"));
            fxmlLoader.setController(learnControllerHandler);
            fxmlLoader.setRoot(learnControllerHandler);

            Parent root1 = (Parent) fxmlLoader.load();
            learnControllerHandler = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Go");
            stage.setScene(new Scene(root1));
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                public void handle(WindowEvent t) {
                    learnControllerHandler = null;
                }
            });
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }




}
