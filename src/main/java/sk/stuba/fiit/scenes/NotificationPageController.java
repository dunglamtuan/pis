package sk.stuba.fiit.scenes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sk.stuba.fiit.labss2.pis.students.team076majitel.Team076MajitelPortType;
import sk.stuba.fiit.labss2.pis.students.team076majitel.Team076MajitelService;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.ArrayOfMajitels;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.Majitel;
import sk.stuba.fiit.labss2.pis.students.team076majitel.types.Majitels;

import java.io.IOException;

public class NotificationPageController {

    @FXML
    CheckBox on_checkbox;

    @FXML
    CheckBox off_checkbox;

    @FXML
    TextField value_textfield;

    @FXML
    Button confirm_button;

    @FXML
    Button back_button;

    @FXML
    private void initialize(){
        on_checkbox.setSelected(true);
        on_checkbox.setOnAction(event -> {
            if (off_checkbox.isSelected()){
                off_checkbox.setSelected(false);
                on_checkbox.setSelected(true);
            }
        });

        off_checkbox.setOnAction(event -> {
            if (on_checkbox.isSelected()) {
                on_checkbox.setSelected(false);
                off_checkbox.setSelected(true);
            }

        });

        confirm_button.setOnMouseClicked(event -> {
            String fxml = "/AdminPage.fxml";
            if (on_checkbox.isSelected())
                setNotification(Integer.valueOf(value_textfield.getText()), true);

            else
                setNotification(Integer.valueOf(value_textfield.getText()), false);

            creteNewWindow(fxml);
        });

        back_button.setOnMouseClicked(event -> {
            String fxml = "/AdminPage.fxml";
            creteNewWindow(fxml);
        });

        value_textfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.isEmpty() && newValue.matches("[1-5]")) {
                    //if (!newValue.isEmpty())
                        value_textfield.setText(newValue);
                }else
                    value_textfield.setText("");
            }
        });
    }

    private void setNotification(int notification_value, boolean on){
        Team076MajitelService service = new Team076MajitelService();
        Team076MajitelPortType port = service.getTeam076MajitelPort();

        Majitels owner = port.getAll().getMajitel().get(0);
        Majitel majitel = new Majitel();
        majitel.setHodnotaNotifikacie(notification_value);
        majitel.setName(owner.getName());
        majitel.setNotifikacia(on);

        port.update("076", "GS3kMb", owner.getId(), majitel);

    }

    private void creteNewWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));

        try {
            Parent parent = (Parent) loader.load();
            AnchorPane root = (AnchorPane) parent;
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage s = (Stage) confirm_button.getScene().getWindow();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
