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

public class CustomerPageController {

    private int userid;

    private static int cafe_id;

    @FXML
    TableView my_cofes_tableview;

    @FXML
    TextField adresa_textfield;

    @FXML
    TextField priemer_textfield;

    @FXML
    TextField mojehod_textfield;

    @FXML
    Button back_button;

    @FXML
    Button change_rate_button;

    @FXML
    private void initialize(){

        adresa_textfield.setEditable(false);
        priemer_textfield.setEditable(false);

        TableColumn adresa_column = new TableColumn("Adresa");
        adresa_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("adresa"));

        TableColumn rate_column = new TableColumn("Priemerne hodnotenie");
        rate_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("hodnotenie"));

        TableColumn my_rate_column = new TableColumn("Moje hodnotenie");
        rate_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("mojeHodnotenie"));

        //ObservableList<TableData> result = FXCollections.observableArrayList(new TableData("0", "asdasd"));
        my_cofes_tableview.setItems(getTableDate());
        my_cofes_tableview.getColumns().addAll(adresa_column, rate_column, my_rate_column);

        my_cofes_tableview.setRowFactory(tv -> {
            TableRow<MyTableData> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    MyTableData clickedRow = row.getItem();
                    cafe_id = Integer.valueOf(clickedRow.getId());
                    adresa_textfield.setText(clickedRow.getAdresa());
                    priemer_textfield.setText(clickedRow.getHodnotenie());
                    mojehod_textfield.setText(clickedRow.getMojeHodnotenie());
                }
            });
            return row ;
        });

        change_rate_button.setOnMouseClicked(event -> {
            int rating = Integer.valueOf(mojehod_textfield.getText());
            updateMyRating(rating);
        });

        back_button.setOnMouseClicked(event -> {
            String fxmlPath = "/LoginPage.fxml";
            creteNewWindow(fxmlPath);
        });

    }

    private ObservableList<MyTableData> getTableDate(){
        Team076KaviarenService service = new Team076KaviarenService();
        Team076KaviarenPortType port = service.getTeam076KaviarenPort();
        ArrayOfKaviarens allKaviaren = port.getAll();
        List<Kaviarens> listKaviaren = allKaviaren.getKaviaren();


        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies kaviaren_id = hodnoteniePort.getAll();
        List<Hodnotenies> hodnotenia = kaviaren_id.getHodnoteny();

        List<Hodnotenies> collect1 = hodnotenia.stream().filter(item -> item.getZakaznikId() == userid).collect(Collectors.toList());
        int mojeHodnotenie = 0;
        if (collect1.size() > 0)
            mojeHodnotenie = collect1.get(0).getHodnota();

        ObservableList<MyTableData> result = FXCollections.observableArrayList();
        for (Kaviarens kaviaren : listKaviaren) {
            List<Hodnotenies> collect = hodnotenia.stream()
                    .filter(item -> item.getKaviarenId() == kaviaren.getId())
                    .collect(Collectors.toList());
            int sum = collect.stream().mapToInt(Hodnotenies::getHodnota).sum();
            double average = 0;
            if (collect.size()>0)
                average = (double) sum / collect.size();


            result.add(new MyTableData(String.valueOf(kaviaren.getId()), kaviaren.getAdresa(),
                    String.valueOf(average), String.valueOf(mojeHodnotenie)));
        }

        return result;
    }

    public void updateMyRating(int myInputRating){
        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies kaviaren_id = hodnoteniePort.getAll();
        List<Hodnotenies> hodnotenia = kaviaren_id.getHodnoteny();
        List<Hodnotenies> myRating = hodnotenia.stream()
                .filter(item -> item.getZakaznikId() == this.userid)
                .collect(Collectors.toList());

        Hodnotenie hodnotenie;
        if (myRating.isEmpty()){
            hodnotenie = new Hodnotenie();
            hodnotenie.setName("");
            hodnotenie.setKaviarenId(cafe_id);
            hodnotenie.setHodnota(myInputRating);
            hodnotenie.setBoloVidene(false);
            hodnotenie.setZakaznikId(this.userid);

            hodnoteniePort.insert("076", "GS3kMb", hodnotenie);
        } else {
            Hodnotenies myCurrentRating = myRating.get(0);
            hodnotenie = new Hodnotenie();
            hodnotenie.setName("");
            hodnotenie.setKaviarenId(myCurrentRating.getKaviarenId());
            hodnotenie.setHodnota(myCurrentRating.getHodnota());
            hodnotenie.setBoloVidene(false);
            hodnotenie.setZakaznikId(myCurrentRating.getZakaznikId());
            myCurrentRating.setHodnota(myInputRating);
            hodnoteniePort.update("076", "GS3kMb", myCurrentRating.getId(), hodnotenie);
        }

    }

    public static class MyTableData{

        private final SimpleStringProperty id;
        private final SimpleStringProperty  adresa;
        private final SimpleStringProperty  hodnotenie;
        private final SimpleStringProperty  mojeHodnotenie;

        MyTableData(String id, String adresa, String hodnotenie, String mojehod) {
            this.id = new SimpleStringProperty(id);
            this.adresa = new SimpleStringProperty(adresa);
            this.hodnotenie = new SimpleStringProperty(hodnotenie);
            this.mojeHodnotenie = new SimpleStringProperty(mojehod);
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

        public String getMojeHodnotenie() {
            return mojeHodnotenie.get();
        }

        public void setMojeHodnotenie(String hodnotenie) {
            this.mojeHodnotenie.set(hodnotenie);
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

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
