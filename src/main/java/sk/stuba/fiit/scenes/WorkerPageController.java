package sk.stuba.fiit.scenes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkerPageController {

    private int cafeid;

    @FXML
    Button registration_button;

    @FXML
    Button add_to_account_button;

    @FXML
    Button logout_button;

    @FXML
    public void initialize(int cafeid){
        this.cafeid = cafeid;
        registration_button.setOnMouseClicked(event -> {
            String fxml = "/UserRegistrationPage.fxml";
            creteNewWindow(fxml);
        });

        add_to_account_button.setOnMouseClicked(event -> {
            String fxml = "/AddToCardPage.fxml";
            creteNewWindow(fxml);
        });

        logout_button.setOnMouseClicked(event -> {
            String fxml = "/LoginPage.fxml";
            creteNewWindow(fxml);
        });
    }

    private void creteNewWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));

        try {
            Parent load = (Parent) loader.load();
            if (fxmlPath.contains("AddToCard")) {
                AddToCardPageController controller = loader.<AddToCardPageController>getController();
                controller.initialize(this.cafeid);
            }
            if (fxmlPath.contains("UserRegistration")) {
                UserRegistrationPageController controller = loader.<UserRegistrationPageController>getController();
                controller.initialize(this.cafeid);
            }
            AnchorPane root = (AnchorPane) load;
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage s = (Stage) logout_button.getScene().getWindow();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCafeid(int cafeid) {
        this.cafeid = cafeid;
    }
}
