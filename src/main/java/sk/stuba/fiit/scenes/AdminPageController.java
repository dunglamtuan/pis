package sk.stuba.fiit.scenes;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnoteniePortType;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.ArrayOfHodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.Hodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviarens;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminPageController {

    @FXML
    Button notification_setting_button;

    @FXML
    TableView cafes_tableview;

    @FXML
    TableView notification_tableview;

    @FXML
    TextField average_textfield;

    @FXML
    TextField adresa_textfield;

    @FXML
    private void initialize(){

        notification_setting_button.setOnMouseClicked(event -> {
            String fxmlPath = "/NotificationPage.fxml";
            creteNewWindow(fxmlPath);
        });

        TableColumn name_column = new TableColumn("Meno");
        name_column.setPrefWidth(cafes_tableview.getPrefWidth()/3);

        TableColumn adress_column = new TableColumn("Adresa");
        adress_column.setPrefWidth(cafes_tableview.getPrefWidth()/3);

        TableColumn average_column = new TableColumn("Priemerne hodnotenie");
        average_column.setPrefWidth(cafes_tableview.getPrefWidth()/3);

        cafes_tableview.setItems(getTableDate());
        cafes_tableview.getColumns().addAll(name_column, adress_column, average_column);

    }

    ObservableList<TableData> getTableDate(){
        Team076KaviarenService service = new Team076KaviarenService();
        Team076KaviarenPortType port = service.getTeam076KaviarenPort();
        ArrayOfKaviarens allKaviaren = port.getAll();
        List<Kaviarens> listKaviaren = allKaviaren.getKaviaren();

        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies kaviaren_id = hodnoteniePort.getAll();
        List<Hodnotenies> hodnotenia = kaviaren_id.getHodnoteny();

        ObservableList<TableData> result = FXCollections.observableArrayList();
        for (Kaviarens kaviaren : listKaviaren) {
            List<Hodnotenies> collect = hodnotenia.stream()
                    .filter(item -> item.getKaviarenId() == kaviaren.getId())
                    .collect(Collectors.toList());
            int sum = collect.stream().mapToInt(Hodnotenies::getHodnota).sum();
            double average = 0;
            if (collect.size()>0)
                average = (double) sum / collect.size();

            result.add(new TableData(String.valueOf(kaviaren.getId()), kaviaren.getAdresa(), String.valueOf(average)));
        }

        return result;
    }

    public static class TableData{

        private final SimpleStringProperty id;
        private final SimpleStringProperty  adresa;
        private final SimpleStringProperty  hodnotenie;

        TableData(String id, String adresa, String hodnotenie) {
            this.id = new SimpleStringProperty(id);
            this.adresa = new SimpleStringProperty(adresa);
            this.hodnotenie = new SimpleStringProperty(hodnotenie);
        }

        public String getId() {
            return id.get();
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getAdresa() {
            return adresa.get();
        }

        public void setAdresa(String adresa) {
            this.adresa.set(adresa);
        }

        public String getHodnotenie() {
            return hodnotenie.get();
        }

        public void setHodnotenie(String hodnotenie) {
            this.hodnotenie.set(hodnotenie);
        }
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
            Stage s = (Stage) adresa_textfield.getScene().getWindow();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
