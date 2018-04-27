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
import sk.stuba.fiit.labss2.pis.students.team076navsteva.Team076NavstevaPortType;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.Team076NavstevaService;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.ArrayOfNavstevas;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.Navstevas;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerPageController {

    private Integer userid;

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
    Label succ_label;

    @FXML
    TextArea comment_textarea;

    @FXML
    void initialize(int userid){
        this.userid = userid;

        my_cofes_tableview.getColumns().clear();
        my_cofes_tableview.getItems().clear();

        adresa_textfield.setEditable(false);
        priemer_textfield.setEditable(false);
        succ_label.setVisible(false);

        TableColumn name_column = new TableColumn("Meno");
        name_column.setPrefWidth(my_cofes_tableview.getPrefWidth()/4);
        name_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("name"));

        TableColumn adresa_column = new TableColumn("Adresa");
        adresa_column.setPrefWidth(my_cofes_tableview.getPrefWidth()/4);
        adresa_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("adresa"));

        TableColumn rate_column = new TableColumn("Priemerne hodnotenie");
        rate_column.setPrefWidth(my_cofes_tableview.getPrefWidth()/4);
        rate_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("hodnotenie"));

        TableColumn my_rate_column = new TableColumn("Moje hodnotenie");
        my_rate_column.setPrefWidth(my_cofes_tableview.getPrefWidth()/4);
        my_rate_column.setCellValueFactory(new PropertyValueFactory<MyTableData, String>("mojeHodnotenie"));

        //ObservableList<TableData> result = FXCollections.observableArrayList(new TableData("0", "asdasd"));
        my_cofes_tableview.setItems(getTableDate());
        my_cofes_tableview.getColumns().addAll(name_column, adresa_column, rate_column, my_rate_column);

        my_cofes_tableview.setRowFactory(tv -> {
            TableRow<MyTableData> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    MyTableData clickedRow = row.getItem();
                    cafe_id = Integer.valueOf(clickedRow.getId());
                    System.out.println("CafeId is: " + cafe_id);
                    adresa_textfield.setText(clickedRow.getAdresa());
                    priemer_textfield.setText(clickedRow.getHodnotenie());
                    mojehod_textfield.setText(clickedRow.getMojeHodnotenie());
                    comment_textarea.setText(clickedRow.getKomentar());
                }
            });
            return row ;
        });

        adresa_textfield.textProperty().addListener((observable, oldValue, newValue) -> {
            succ_label.setVisible(false);
        });

        change_rate_button.setOnMouseClicked(event -> {
            int rating = Integer.valueOf(mojehod_textfield.getText());
            updateMyRating(rating);
            initialize(userid);
            succ_label.setVisible(true);

        });

        back_button.setOnMouseClicked(event -> {
            String fxmlPath = "/LoginPage.fxml";
            creteNewWindow(fxmlPath);
        });

    }

    private ObservableList<MyTableData> getTableDate(){
        Team076NavstevaService navstevaService = new Team076NavstevaService();
        Team076NavstevaPortType navstevaPort = navstevaService.getTeam076NavstevaPort();
        ArrayOfNavstevas zakaznik_id = navstevaPort.getByAttributeValue("zakaznik_id", String.valueOf(this.userid), new ArrayOfIds());
        List<Navstevas> navstevaListByUserId = zakaznik_id.getNavsteva();

        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies all = hodnoteniePort.getAll();
        List<Hodnotenies> allHodnotenia = all.getHodnoteny();

        Team076KaviarenService kaviarenService = new Team076KaviarenService();
        Team076KaviarenPortType kaviarenPort = kaviarenService.getTeam076KaviarenPort();
        ArrayOfKaviarens allCafe = kaviarenPort.getAll();
        List<Kaviarens> allKaviaren = allCafe.getKaviaren();

        ObservableList<MyTableData> result = FXCollections.observableArrayList();
        for (Navstevas navsteva : navstevaListByUserId) {
            int kaviarenId = navsteva.getKaviarenId();
            System.out.println("Primer: "+String.valueOf(getAverageByCafeId(allHodnotenia, kaviarenId)));
            result.add(new MyTableData(String.valueOf(kaviarenId), getCafeNameByCafeId(allKaviaren, kaviarenId),
                    getCafeAddressByCafeId(allKaviaren, kaviarenId), String.valueOf(getAverageByCafeId(allHodnotenia, kaviarenId)),
                    String.valueOf(getMyRateByCafeId(allHodnotenia, kaviarenId)<= 0 ? "" : (getMyRateByCafeId(allHodnotenia, kaviarenId))),
                    getMyCommentByCafeId(allHodnotenia, kaviarenId)));
        }

        return result;
    }

    private double getAverageByCafeId(List<Hodnotenies> allHodnotenia, int cafeId) {
        List<Hodnotenies> listByCafeId = allHodnotenia.stream().filter(item -> item.getKaviarenId() == cafeId).collect(Collectors.toList());

        int sum = listByCafeId.stream().mapToInt(Hodnotenies::getHodnota).sum();
        return (double) sum / listByCafeId.size();
    }

    private int getMyRateByCafeId(List<Hodnotenies> allHodnotenia, int cafeId) {
        List<Hodnotenies> collectMyRate = allHodnotenia
                .stream()
                .filter(item -> item.getKaviarenId() == cafeId && item.getZakaznikId() == userid)
                .collect(Collectors.toList());

        if (collectMyRate.isEmpty())
            return -1;
        else
            return collectMyRate.get(0).getHodnota();

    }

    private String getMyCommentByCafeId(List<Hodnotenies> allHodnotenia, int cafeId) {
        List<Hodnotenies> collectMyRate = allHodnotenia
                .stream()
                .filter(item -> item.getKaviarenId() == cafeId && item.getZakaznikId() == userid)
                .collect(Collectors.toList());

        if (collectMyRate.isEmpty())
            return "";
        else
            return collectMyRate.get(0).getKomentar();
    }

    private String getCafeNameByCafeId(List<Kaviarens> allKaviaren, int cafeId) {
        return allKaviaren.stream().filter(item -> item.getId() == cafeId).collect(Collectors.toList()).get(0).getName();
    }

    private String getCafeAddressByCafeId(List<Kaviarens> allKaviaren, int cafeId) {
        return allKaviaren.stream().filter(item -> item.getId() == cafeId).collect(Collectors.toList()).get(0).getAdresa();
    }

    private void updateMyRating(int myInputRating) {
        System.out.println("updateMyRating, userId is " + userid);
        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies kaviaren_id = hodnoteniePort.getAll();
        List<Hodnotenies> hodnotenia = kaviaren_id.getHodnoteny();
        List<Hodnotenies> myRating = hodnotenia.stream()
                .filter(item -> item.getZakaznikId() == this.userid && item.getKaviarenId() == cafe_id)
                .collect(Collectors.toList());

        Hodnotenie hodnotenie;
        if (myRating.isEmpty()){
            System.out.println("myRating is empty, inserting new instance");
            hodnotenie = new Hodnotenie();
            hodnotenie.setName("");
            hodnotenie.setKaviarenId(cafe_id);
            hodnotenie.setHodnota(myInputRating);
            hodnotenie.setBoloVidene(false);
            hodnotenie.setZakaznikId(this.userid);
            hodnotenie.setKomentar(comment_textarea.getText());

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(Calendar.getInstance().getTime());
            try {
                hodnotenie.setDatumPridania(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }

            hodnoteniePort.insert("076", "GS3kMb", hodnotenie);
        } else {
            System.out.println("myRating is not empty, updateing an instance");
            Hodnotenies myCurrentRating = myRating.get(0);
            hodnotenie = new Hodnotenie();
            hodnotenie.setHodnota(myInputRating);
            hodnotenie.setBoloVidene(false);
            hodnotenie.setId(myCurrentRating.getId());
            hodnotenie.setZakaznikId(myCurrentRating.getZakaznikId());
            hodnotenie.setKaviarenId(myCurrentRating.getKaviarenId());


            GregorianCalendar c = new GregorianCalendar();
            c.setTime(Calendar.getInstance().getTime());
            try {
                hodnotenie.setDatumPridania(DatatypeFactory.newInstance().newXMLGregorianCalendar(c));
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            hodnotenie.setKomentar(comment_textarea.getText());

            hodnoteniePort.update("076", "GS3kMb", myCurrentRating.getId(), hodnotenie);
        }

    }

    public static class MyTableData{

        private final SimpleStringProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty adresa;
        private final SimpleStringProperty hodnotenie;
        private final SimpleStringProperty mojeHodnotenie;
        private final SimpleStringProperty komentar;

        MyTableData(String id, String name, String adresa, String hodnotenie, String mojehod, String komentar) {
            this.id = new SimpleStringProperty(id);
            this.name = new SimpleStringProperty(name);
            this.adresa = new SimpleStringProperty(adresa);
            this.hodnotenie = new SimpleStringProperty(hodnotenie);
            this.mojeHodnotenie = new SimpleStringProperty(mojehod);
            this.komentar = new SimpleStringProperty(komentar);
        }

        public String getId() {
            return id.get();
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getName(){
            return name.get();
        }

        public void setName(String name){
            this.name.set(name);
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

        public void setMojeHodnotenie(String mojeHodnotenie) {
            this.mojeHodnotenie.set(mojeHodnotenie);
        }

        public String getKomentar() {
            return komentar.get();
        }

        public void setKomentar(String komentar) {
            this.komentar.set(komentar);
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

    public void setUserid(int useridd) {
        this.userid = useridd;
    }
}
