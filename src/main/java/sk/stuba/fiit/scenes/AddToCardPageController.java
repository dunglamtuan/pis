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
import sk.stuba.fiit.labss2.pis.students.team076navsteva.Team076NavstevaPortType;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.Team076NavstevaService;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.ArrayOfNavstevas;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.Navsteva;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.Navstevas;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikPortType;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakazniks;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AddToCardPageController {

    private int kaviarenId;

    private static Zakazniks zakaznik = null;

    @FXML
    TextField cardid_textfield;

    @FXML
    Button confirm_button;

    @FXML
    Button back_button;

    @FXML
    Label error_label;

    @FXML
    public void initialize(int kaviarenId){
        this.kaviarenId = kaviarenId;
        error_label.setVisible(false);

        cardid_textfield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cardid_textfield.setText(newValue.replaceAll("[^\\d]", ""));
                }
                error_label.setVisible(false);
            }
        });

        confirm_button.setOnMouseClicked(event -> {
            String cardid_input = cardid_textfield.getText();

            if (getZakaznikFromCardId(cardid_input) == null) {
                error_label.setVisible(true);
            }else {
                addTCard(cardid_input);

                String fxmlPath = "/WorkerPage.fxml";
                creteNewWindow(fxmlPath);
            }
        });

        back_button.setOnMouseClicked(event -> {
            String fxmlPath = "/WorkerPage.fxml";
            creteNewWindow(fxmlPath);
        });
    }

    private Zakazniks getZakaznikFromCardId(String cardId) {
        Team076ZakaznikService zakaznikService = new Team076ZakaznikService();
        Team076ZakaznikPortType zakaznikPort = zakaznikService.getTeam076ZakaznikPort();

        List<Zakazniks> zakaznikList = zakaznikPort.getByAttributeValue("cislo_karty ", cardId,
                new sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.ArrayOfIds()).getZakaznik();

        if (!zakaznikList.isEmpty()){
            zakaznik = zakaznikList.get(0);
            return zakaznik;
        }
        else return null;
    }

    private void addTCard(String cardid){
        Team076NavstevaService navstevaService = new Team076NavstevaService();
        Team076NavstevaPortType port = navstevaService.getTeam076NavstevaPort();

        ArrayOfNavstevas navstevas = port.getByAttributeValue("zakaznik_id ",
                String.valueOf(zakaznik.getId()), new ArrayOfIds());
        List<Navstevas> navstevaList = navstevas.getNavsteva();
        List<Navstevas> collect = navstevaList.stream()
                .filter(nav -> nav.getKaviarenId() == this.kaviarenId)
                .collect(Collectors.toList());

        Navsteva navsteva = null;
        if (collect.isEmpty()) {
            navsteva = new Navsteva();
            navsteva.setName("");
            navsteva.setKaviarenId(this.kaviarenId);
            navsteva.setPocetNavstev(1);
            navsteva.setZakaznikId(Integer.valueOf(cardid));

            port.insert("076", "GS3kMb", navsteva);
        } else {
            Navstevas navstevas1 = collect.get(0);
            navsteva = new Navsteva();
            navsteva.setZakaznikId(navstevas1.getZakaznikId());
            navsteva.setPocetNavstev(navstevas1.getPocetNavstev()+1);
            navsteva.setKaviarenId(navstevas1.getKaviarenId());

            port.update("076", "GS3kMb", navstevas1.getId(), navsteva);
        }
    }

    private void creteNewWindow(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));

        try {
            Parent parent = (Parent) loader.load();

            WorkerPageController controller = loader.<WorkerPageController>getController();
            System.out.println("Contains worker");
            controller.setCafeid(this.kaviarenId);


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

    public void setKaviarenId(int kaviarenId) {
        this.kaviarenId = kaviarenId;
    }
}



