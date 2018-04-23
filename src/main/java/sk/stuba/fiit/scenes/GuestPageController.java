package sk.stuba.fiit.scenes;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnoteniePortType;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.ArrayOfHodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.Hodnotenie;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.Hodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviarens;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class GuestPageController {

    private static int cafe_id;

    @FXML
    TableView<TableData> cafes_table;

    @FXML
    TextField adresa_textfield;

    @FXML
    TextField average_rate_textfield;

    @FXML
    TextArea comment_textarea;

    @FXML
    TextField my_rate;

    @FXML
    Button send_rating_button;

    @FXML
    Button back_button;

    @FXML
    Label info_label;

    @FXML
    private void initialize(){
        adresa_textfield.setEditable(false);
        average_rate_textfield.setEditable(false);

        TableColumn adresa_column = new TableColumn("Adresa");
        adresa_column.setCellValueFactory(new PropertyValueFactory<TableData, String>("adresa"));

        TableColumn rate_column = new TableColumn("Priemerne hodnotenie");
        rate_column.setCellValueFactory(new PropertyValueFactory<TableData, String>("hodnotenie"));

        //ObservableList<TableData> result = FXCollections.observableArrayList(new TableData("0", "asdasd"));
        cafes_table.setItems(getTableDate());
        cafes_table.getColumns().addAll(adresa_column,rate_column);

        cafes_table.setRowFactory(tv -> {
            TableRow<TableData> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    TableData clickedRow = row.getItem();
                    cafe_id = Integer.valueOf(clickedRow.getId());
                    adresa_textfield.setText(clickedRow.getAdresa());
                    average_rate_textfield.setText(clickedRow.getHodnotenie());
                }
            });
            return row ;
        });

        send_rating_button.setOnMouseClicked(event -> {
            sendMyRating(Integer.valueOf(my_rate.getText()));
        });

        adresa_textfield.textProperty().addListener((observable, oldValue, newValue) -> {
            info_label.setVisible(false);
        });

        info_label.setVisible(false);

        back_button.setOnMouseClicked(event -> {
            String fxmlPath = "/LoginPage.fxml";
            creteNewWindow(fxmlPath);
        });

    }

    private void sendMyRating(int rating){
        Team076HodnotenieService service = new Team076HodnotenieService();
        Team076HodnoteniePortType port = service.getTeam076HodnoteniePort();

        Hodnotenie hodnotenie = new Hodnotenie();
        hodnotenie.setName("");
        hodnotenie.setBoloVidene(false);
        hodnotenie.setHodnota(rating);
        hodnotenie.setKaviarenId(cafe_id);

        port.insert("076", "GS3kMb", hodnotenie);
        info_label.setVisible(true);
        info_label.setText("Uspesne");
    }

    private ObservableList<TableData> getTableDate(){
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
            Stage s = (Stage) back_button.getScene().getWindow();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
