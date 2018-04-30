package sk.stuba.fiit.scenes;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
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

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class GuestPageController {

    private static int cafe_id;

    @FXML
    TableView<TableData> cafes_table;

    @FXML
    TextField adresa_textfield;

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

        ObservableList<TableData> tableDate = getTableDate();

        initTableView(tableDate);

        send_rating_button.setOnMouseClicked(event -> sendMyRating(Integer.valueOf(my_rate.getText()), tableDate));

        adresa_textfield.textProperty().addListener((observable, oldValue, newValue) -> {
            info_label.setVisible(false);
            comment_textarea.setText("");
            my_rate.setText("");
        });

        info_label.setVisible(false);

        back_button.setOnMouseClicked(event -> {
            String fxmlPath = "/LoginPage.fxml";
            creteNewWindow(fxmlPath);
        });

        my_rate.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && newValue.matches("[1-5]")) {
                my_rate.setText(newValue);
            }else
                my_rate.setText("");
        });

        TableColumn adresa_column = new TableColumn("Adresa");
        adresa_column.setCellValueFactory(new PropertyValueFactory<TableData, String>("adresa"));

        TableColumn name_column = new TableColumn("Meno");
        name_column.setCellValueFactory(new PropertyValueFactory<TableData, String>("name"));

        TableColumn my_rating_column = new TableColumn("Moje hodnotenie");
        my_rating_column.setCellValueFactory(new PropertyValueFactory<TableData, String>("myHodnotenie"));
        cafes_table.getColumns().addAll(adresa_column, name_column, my_rating_column);

        cafes_table.setRowFactory(tv -> {
            TableRow<TableData> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    TableData clickedRow = row.getItem();
                    cafe_id = Integer.valueOf(clickedRow.getId());
                    adresa_textfield.setText(clickedRow.getAdresa());
                }
            });
            return row ;
        });

    }

    private void initTableView(ObservableList<TableData> tableDate){
        cafes_table.getItems().clear();
        //cafes_table.getColumns().clear();
        cafes_table.setItems(tableDate);

    }

    private void sendMyRating(int rating, ObservableList<TableData> tableDate){
        for (TableData tableData : tableDate) {
            if (tableData.getId().equalsIgnoreCase(String.valueOf(cafe_id)) && tableData.getBolHodnoteny()){
                info_label.setText("Kaviareň už bola raz hodnotená.");
                info_label.setVisible(true);
                return;
            }
        }

        if (my_rate.getText().isEmpty()){
            info_label.setText("Vyplňte hodnotenie!");
            info_label.setVisible(true);
            return;
        }

        Team076HodnotenieService service = new Team076HodnotenieService();
        Team076HodnoteniePortType port = service.getTeam076HodnoteniePort();

        Hodnotenie hodnotenie = new Hodnotenie();
        hodnotenie.setName("");
        hodnotenie.setBoloVidene(false);
        hodnotenie.setHodnota(rating);
        hodnotenie.setKaviarenId(cafe_id);
        hodnotenie.setKomentar(comment_textarea.getText());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Calendar.getInstance().getTime());
        try {
            hodnotenie.setDatumPridania(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        port.insert("076", "GS3kMb", hodnotenie);
        info_label.setVisible(true);
        info_label.setText("Hodnotenie prebehlo úspešne");

        for (TableData tableData : tableDate) {
            if (tableData.getId().equalsIgnoreCase(String.valueOf(cafe_id))) {
                tableData.setBolHodnoteny(true);
                tableData.setMyHodnotenie(String.valueOf(rating));
                break;
            }
        }

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

            result.add(new TableData(String.valueOf(kaviaren.getId()),kaviaren.getName(),
                    kaviaren.getAdresa(), String.valueOf(average), false));
        }

        return result;
    }

    public static class TableData{

        private final SimpleStringProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty  adresa;
        private final SimpleStringProperty  hodnotenie;
        private final SimpleBooleanProperty bolHodnoteny;
        private final SimpleStringProperty myHodnotenie;

        TableData(String id, String name, String adresa, String hodnotenie, Boolean bolHodnoteny) {
            this.id = new SimpleStringProperty(id);
            this.adresa = new SimpleStringProperty(adresa);
            this.hodnotenie = new SimpleStringProperty(hodnotenie);
            this.name = new SimpleStringProperty(name);
            this.bolHodnoteny = new SimpleBooleanProperty(bolHodnoteny);
            this.myHodnotenie = new SimpleStringProperty();
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

        public String getName() {
            return name.get();
        }

        public void setName(String name){
            this.name.set(name);
        }

        public Boolean getBolHodnoteny() {
            return bolHodnoteny.get();
        }

        public void setBolHodnoteny(Boolean bolHodnoteny) {
            this.bolHodnoteny.set(bolHodnoteny);
        }

        public String getMyHodnotenie() {
            return myHodnotenie.get();
        }

        public void setMyHodnotenie(String hodnotenie) {
            this.myHodnotenie.set(hodnotenie);
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
