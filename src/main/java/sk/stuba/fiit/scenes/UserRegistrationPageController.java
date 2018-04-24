package sk.stuba.fiit.scenes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviarens;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikPortType;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.ArrayOfZakazniks;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakaznik;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakazniks;
import sk.stuba.fiit.labss2.pis.validator.ValidatorPortType;
import sk.stuba.fiit.labss2.pis.validator.ValidatorService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class UserRegistrationPageController {

    private int cafeid;

    @FXML
    TextField name_textfield;

    @FXML
    TextField email_textfield;

    @FXML
    TextField cardid_textfield;

    @FXML
    Button registration_button;

    @FXML
    Button back_button;

    @FXML
    TextField pass_textfield;

    @FXML
    Label mail_error_label;

    @FXML
    public void initialize(int cafeid){
        this.cafeid = cafeid;

        mail_error_label.setVisible(false);

        cardid_textfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cardid_textfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        cardid_textfield.textProperty().addListener((observable, oldValue, newValue) -> {
            mail_error_label.setVisible(false);
        });

        registration_button.setOnMouseClicked(event ->{
            String nameInput =  name_textfield.getText();
            String email_input = email_textfield.getText();
            String cardd_input = cardid_textfield.getText();
            String pass = pass_textfield.getText();

            if (!validateEmailInput(email_input)){
                mail_error_label.setText("Neplatna emailova adresa");
                mail_error_label.setVisible(true);
            } else if (isCardIdExisted(Integer.valueOf(cardd_input))){
                mail_error_label.setText("Cislo karty uz existuje");
                mail_error_label.setVisible(true);
            } else if (isCardInputAsKaviarenId(Integer.valueOf(cardd_input))){
                mail_error_label.setText("Cislo karty uz existuje");
                mail_error_label.setVisible(true);
            } else {
                registerNewUser(nameInput, email_input, cardd_input, pass);

                String fxmlPath = "/WorkerPage.fxml";
                creteNewWindow(fxmlPath);
            }
        });

        back_button.setOnMouseClicked(event -> {
            String fxmlPath = "/WorkerPage.fxml";
            creteNewWindow(fxmlPath);
        });
    }

    private void registerNewUser(String name, String email, String cardid, String pass){
        Team076ZakaznikService service = new Team076ZakaznikService();
        Team076ZakaznikPortType port = service.getTeam076ZakaznikPort();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setCisloKarty(Integer.valueOf(cardid));
        zakaznik.setName(name);
        zakaznik.setEmail(email);
        zakaznik.setHeslo(pass);

        port.insert("076", "GS3kMb", zakaznik);
    }

    private void creteNewWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));

        try {
            Parent parent = (Parent) loader.load();

            WorkerPageController controller = loader.<WorkerPageController>getController();
            System.out.println("Contains worker");
            controller.setCafeid(this.cafeid);


            AnchorPane root = (AnchorPane) parent;
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage s = (Stage) registration_button.getScene().getWindow();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validateEmailInput(String email){
        ValidatorService service = new ValidatorService();
        ValidatorPortType port = service.getValidatorPort();

        return port.validateEmail(email);
    }

    private boolean isCardIdExisted(int cardId) {
        Team076ZakaznikService service = new Team076ZakaznikService();
        Team076ZakaznikPortType port = service.getTeam076ZakaznikPort();

        ArrayOfZakazniks all = port.getAll();
        List<Zakazniks> zakaznikList = all.getZakaznik();

        List<Zakazniks> collect = zakaznikList
                .stream()
                .filter(item -> item.getCisloKarty() == cardId)
                .collect(Collectors.toList());
        return !collect.isEmpty();
    }

    private boolean isCardInputAsKaviarenId(int cardId) {
        Team076KaviarenService service = new Team076KaviarenService();
        Team076KaviarenPortType port = service.getTeam076KaviarenPort();

        List<Kaviarens> kaviarens = port.getAll().getKaviaren();
        return !kaviarens.stream().filter(kaviaren -> kaviaren.getId() == cardId).collect(Collectors.toList()).isEmpty();
    }

    public void setCafeid(int cafeid) {
        this.cafeid = cafeid;
    }
}
