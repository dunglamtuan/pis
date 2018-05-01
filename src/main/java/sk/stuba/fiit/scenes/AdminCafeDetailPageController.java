package sk.stuba.fiit.scenes;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnoteniePortType;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.ArrayOfHodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.Hodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviaren;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikPortType;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakazniks;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminCafeDetailPageController {

    private int cafeid;

    @FXML
    TableView<CafeRateData> all_rate_tableview;

    @FXML
    Label name_label;

    @FXML
    Label adress_label;

    @FXML
    Label average_label;

    @FXML
    Button back_button;

    @FXML
    public void initialize(int cafeid){
        this.cafeid = cafeid;

        back_button.setOnMouseClicked(event -> backToAdminPage("/AdminPage.fxml"));

        initData();
    }

    private void initData() {
        Team076ZakaznikService zakaznikService = new Team076ZakaznikService();
        Team076ZakaznikPortType zakaznikPort = zakaznikService.getTeam076ZakaznikPort();
        List<Zakazniks> zakaznikAllList = zakaznikPort.getAll().getZakaznik();

        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies allKaviarenById =
                hodnoteniePort.getByAttributeValue("kaviaren_id", String.valueOf(cafeid), new ArrayOfIds());
        List<Hodnotenies> hodnoteniaList = allKaviarenById.getHodnoteny();

        ObservableList<CafeRateData> result = FXCollections.observableArrayList();
        for (Hodnotenies hodnotenie : hodnoteniaList) {
            String customerName;
            if (hodnotenie.getZakaznikId()<=0) {
                customerName = "Anonym";
            } else {
                customerName = zakaznikAllList.stream()
                        .filter(zakaznik -> zakaznik.getId() == hodnotenie.getZakaznikId())
                        .map(Zakazniks::getName).collect(Collectors.toList()).get(0);
            }

            result.add(new CafeRateData(customerName,
                    String.valueOf(hodnotenie.getHodnota()),
                    hodnotenie.getDatumPridania()!= null ? String.valueOf(hodnotenie.getDatumPridania()) : "",
                    hodnotenie.getKomentar()));
        }

        TableColumn zakaznik_column = new TableColumn("Zakaznik");
        zakaznik_column.setPrefWidth(all_rate_tableview.getPrefWidth()/4);
        zakaznik_column.setCellValueFactory(new PropertyValueFactory<CafeRateData, String>("zakaznikId"));

        TableColumn hodnota_column = new TableColumn("Hodnota");
        hodnota_column.setPrefWidth(all_rate_tableview.getPrefWidth()/4);
        hodnota_column.setCellValueFactory(new PropertyValueFactory<CafeRateData, String>("hodnota"));

        TableColumn date_column = new TableColumn("Datum pridania");
        date_column.setPrefWidth(all_rate_tableview.getPrefWidth()/4);
        date_column.setCellValueFactory(new PropertyValueFactory<CafeRateData, String>("datumPridania"));

        TableColumn comment_column = new TableColumn("Komentar");
        comment_column.setPrefWidth(all_rate_tableview.getPrefWidth()/4);
        comment_column.setCellValueFactory(new PropertyValueFactory<CafeRateData, String>("komentar"));

        all_rate_tableview.setItems(result);
        all_rate_tableview.getColumns().addAll(zakaznik_column, hodnota_column, date_column, comment_column);

        fillCafeBasicDetail(hodnoteniaList);
    }

    public static class CafeRateData{

        private final SimpleStringProperty zakaznikId;
        private final SimpleStringProperty  hodnota;
        private final SimpleStringProperty  datumPridania;
        private final SimpleStringProperty komentar;

        public CafeRateData(String zakaznik_id, String hodnota, String datumPridania, String komentar) {
            this.zakaznikId = new SimpleStringProperty(zakaznik_id);
            this.hodnota = new SimpleStringProperty(hodnota);
            this.datumPridania = new SimpleStringProperty(datumPridania);
            this.komentar = new SimpleStringProperty(komentar);
        }

        public String getZakaznikId() {
            return zakaznikId.get();
        }

        public void setZakaznikId(String zakaznik_id) {
            this.zakaznikId.set(zakaznik_id);
        }

        public String getHodnota() {
            return hodnota.get();
        }

        public void setHodnota(String hodnota) {
            this.hodnota.set(hodnota);
        }

        public String getDatumPridania() {
            return datumPridania.get();
        }

        public void setDatumPridania(String datumPridania) {
            this.datumPridania.set(datumPridania);
        }

        public String getKomentar() {
            return komentar.get();
        }

        public void setKomentar(String komentar) {
            this.komentar.set(komentar);
        }
    }

    private void fillCafeBasicDetail(List<Hodnotenies> hodnoteniaList){
        int sum = hodnoteniaList.stream().mapToInt(Hodnotenies::getHodnota).sum();
        double average = (double) sum / hodnoteniaList.size();

        Team076KaviarenService kaviarenService = new Team076KaviarenService();
        Team076KaviarenPortType kaviarenPort = kaviarenService.getTeam076KaviarenPort();

        Kaviaren byId = kaviarenPort.getById(this.cafeid);
        name_label.setText(byId.getName());
        adress_label.setText(byId.getAdresa());
        average_label.setText(String.valueOf(average));
    }

    private void backToAdminPage(String fxmlPath) {
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
