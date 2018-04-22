package sk.stuba.fiit.scenes;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnoteniePortType;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.ArrayOfHodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.Hodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviarens;

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

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
