package Service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FunctionsForForms {
    public void openStage(String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
