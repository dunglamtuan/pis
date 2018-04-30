package sk.stuba.fiit.scenes;

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
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviarens;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikPortType;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.ArrayOfZakazniks;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakazniks;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LoginPageController {

    private int userid;
    private int cafeid;

    @FXML
    TextField heslo_textfield;

    @FXML
    TextField cardid_textfield;

    @FXML
    Button login_button;

    @FXML
    Button asGuest_button;

    @FXML
    Label error_label;

    @FXML
    Button exit_button;

    @FXML
    private void initialize(){
        error_label.setVisible(false);
        login_button.setOnMouseClicked(event -> {
            String cardInput = cardid_textfield.getText();
            String heslo = heslo_textfield.getText();

            if (isCustomer(cardInput, heslo)){
                String fxmlPath = "/CustomerPage.fxml";
                creteNewWindow(fxmlPath);
            }
            else if (isWorker(cardInput, heslo)){
                String fxmlPath = "/WorkerPage.fxml";
                creteNewWindow(fxmlPath);
            }
            else {
                error_label.setText("Nesprávne ID alebo heslo!");
                error_label.setVisible(true);
            }

        });

        cardid_textfield.textProperty().addListener((observable, oldValue, newValue) -> {
            error_label.setVisible(false);
        });

        asGuest_button.setOnMouseClicked(event -> {
            String fxmlPath = "/GuestPage.fxml";
            creteNewWindow(fxmlPath);
        });

        exit_button.setOnMouseClicked(event -> ((Stage) exit_button.getScene().getWindow()).close());
    }

    private Boolean isCustomer(String cardId, String heslo) {
        Team076ZakaznikService zakaznikService = new Team076ZakaznikService();
        Team076ZakaznikPortType zakaznikPort = zakaznikService.getTeam076ZakaznikPort();

        ArrayOfZakazniks zakazniks = zakaznikPort.getByAttributeValue("cislo_karty", cardId, new ArrayOfIds());
        List<Zakazniks> zakazniksList = zakazniks.getZakaznik();
        if (zakazniksList.isEmpty())
            return false;
        List<Zakazniks> collect = zakazniksList
                .stream()
                .filter(zak -> heslo.equals(zak.getHeslo()))
                .collect(Collectors.toList());
        if (collect.isEmpty()){
            System.out.println("Collect is null");
            return false;
        }
        else {
            this.userid = collect.get(0).getId();
            System.out.println("User id is: " + this.userid);
            return true;
        }

    }

    private Boolean isWorker(String cafeid, String heslo) {
        int cafeIdint = Integer.valueOf(cafeid);
        Team076KaviarenService kaviarenService = new Team076KaviarenService();
        Team076KaviarenPortType kaviarenPort = kaviarenService.getTeam076KaviarenPort();

        ArrayOfKaviarens kaviarens = kaviarenPort.getAll();
        List<Kaviarens> kaviarne = kaviarens.getKaviaren();
        if (kaviarne.isEmpty())
            return false;

        List<Kaviarens> collect = kaviarne.stream()
                .filter(kav -> {
                    return cafeIdint == kav.getId() && heslo.equals(kav.getHeslo());
                })
                .collect(Collectors.toList());
        if (collect.isEmpty())
            return false;
        this.cafeid = collect.get(0).getId();
        return true;
    }

    private Boolean creteNewWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));

        try {
            Parent parent = (Parent) loader.load();
            if (fxmlPath.contains("Customer")) {
                CustomerPageController controller = loader.getController();
                System.out.println("Contains customer");
                controller.initialize(this.userid);
            }

            if (fxmlPath.contains("Worker")) {

                WorkerPageController controller = loader.<WorkerPageController>getController();
                System.out.println("Contains worker");
                controller.initialize(this.cafeid);
            }

            AnchorPane root = (AnchorPane) parent;
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage s = (Stage) login_button.getScene().getWindow();
            s.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
