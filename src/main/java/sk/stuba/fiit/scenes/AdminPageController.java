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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnoteniePortType;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.Team076HodnotenieService;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.ArrayOfHodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076hodnotenie.types.Hodnotenies;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.ArrayOfKaviarens;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviaren;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviarens;
import sk.stuba.fiit.labss2.pis.students.team076majitel.Team076MajitelPortType;
import sk.stuba.fiit.labss2.pis.students.team076majitel.Team076MajitelService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikPortType;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakaznik;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminPageController {

    @FXML
    Button notification_setting_button;

    @FXML
    TableView<AllTableData> cafes_tableview;

    @FXML
    TableView<NotificationData> notification_tableview;

    @FXML
    private void initialize(){

        notification_setting_button.setOnMouseClicked(event -> {
            String fxmlPath = "/NotificationPage.fxml";
            creteNewWindow(fxmlPath,-1);
        });

        TableColumn name_column = new TableColumn("Meno");
        name_column.setPrefWidth(cafes_tableview.getPrefWidth()/3);
        name_column.setCellValueFactory(new PropertyValueFactory<AllTableData, String>("name"));

        TableColumn adress_column = new TableColumn("Adresa");
        adress_column.setPrefWidth(cafes_tableview.getPrefWidth()/3);
        adress_column.setCellValueFactory(new PropertyValueFactory<AllTableData, String>("adresa"));

        TableColumn average_column = new TableColumn("Priemerne hodnotenie");
        average_column.setPrefWidth(cafes_tableview.getPrefWidth()/3);
        average_column.setCellValueFactory(new PropertyValueFactory<AllTableData, String>("hodnotenie"));

        cafes_tableview.setItems(getTableDate());
        cafes_tableview.getColumns().addAll(name_column, adress_column, average_column);

        cafes_tableview.setRowFactory(tv -> {
            TableRow<AllTableData> row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
                        && event.getClickCount() == 2) {

                    AllTableData clickedRow = row.getItem();
                    String fxmlPath = "/AdminCafeDetailPage.fxml";
                    creteNewWindow(fxmlPath, Integer.valueOf(clickedRow.getId()));
                }
            });
            return row ;
        });

        initNotificationTable();

    }

    private ObservableList<AllTableData> getTableDate(){
        Team076KaviarenService service = new Team076KaviarenService();
        Team076KaviarenPortType port = service.getTeam076KaviarenPort();
        ArrayOfKaviarens allKaviaren = port.getAll();
        List<Kaviarens> listKaviaren = allKaviaren.getKaviaren();

        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();
        ArrayOfHodnotenies kaviaren_id = hodnoteniePort.getAll();
        List<Hodnotenies> hodnotenia = kaviaren_id.getHodnoteny();

        ObservableList<AllTableData> result = FXCollections.observableArrayList();
        for (Kaviarens kaviaren : listKaviaren) {
            List<Hodnotenies> collect = hodnotenia.stream()
                    .filter(item -> item.getKaviarenId() == kaviaren.getId())
                    .collect(Collectors.toList());
            int sum = collect.stream().mapToInt(Hodnotenies::getHodnota).sum();
            double average = 0;
            if (collect.size()>0)
                average = (double) sum / collect.size();

            result.add(new AllTableData(String.valueOf(kaviaren.getId()), kaviaren.getName(),
                    kaviaren.getAdresa(), String.valueOf(average)));
        }

        return result;
    }

    public static class AllTableData{

        private final SimpleStringProperty id;
        private final SimpleStringProperty name;
        private final SimpleStringProperty  adresa;
        private final SimpleStringProperty  hodnotenie;

        AllTableData(String id, String name, String adresa, String hodnotenie) {
            this.id = new SimpleStringProperty(id);
            this.name = new SimpleStringProperty(name);
            this.adresa = new SimpleStringProperty(adresa);
            this.hodnotenie = new SimpleStringProperty(hodnotenie);
        }

        public String getId() {
            return id.get();
        }

        public void setId(String id) {
            this.id.set(id);
        }

        public String getName() { return name.get();}

        public void setName(String name) { this.name.set(name);}

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

    private void initNotificationTable(){
        TableColumn cafe_name_column = new TableColumn("Meno");
        cafe_name_column.setPrefWidth(notification_tableview.getPrefWidth()/4);
        cafe_name_column.setCellValueFactory(new PropertyValueFactory<NotificationData, String>("cafeName"));

        TableColumn customer_name_column = new TableColumn("Zakaznik");
        customer_name_column.setPrefWidth(notification_tableview.getPrefWidth()/4);
        customer_name_column.setCellValueFactory(new PropertyValueFactory<NotificationData, String>("customerName"));

        TableColumn rate_column = new TableColumn("Hodnota");
        rate_column.setPrefWidth(notification_tableview.getPrefWidth()/4);
        rate_column.setCellValueFactory(new PropertyValueFactory<NotificationData, String>("rate"));

        TableColumn add_date_column = new TableColumn("Datum");
        add_date_column.setPrefWidth(notification_tableview.getPrefWidth()/4);
        add_date_column.setCellValueFactory(new PropertyValueFactory<NotificationData, String>("date"));

        notification_tableview.setItems(getTableNotifications());
        notification_tableview.getColumns().addAll(cafe_name_column, customer_name_column, rate_column, add_date_column);


    }

    private ObservableList<NotificationData> getTableNotifications(){
        Team076MajitelService majitelService = new Team076MajitelService();
        Team076MajitelPortType majitelPort = majitelService.getTeam076MajitelPort();

        Team076HodnotenieService hodnotenieService = new Team076HodnotenieService();
        Team076HodnoteniePortType hodnoteniePort = hodnotenieService.getTeam076HodnoteniePort();

        Team076ZakaznikService zakaznikService = new Team076ZakaznikService();
        Team076ZakaznikPortType zakaznikPort = zakaznikService.getTeam076ZakaznikPort();

        Team076KaviarenService kaviarenService = new Team076KaviarenService();
        Team076KaviarenPortType kaviarenPort = kaviarenService.getTeam076KaviarenPort();

        if (!majitelPort.getAll().getMajitel().get(0).isNotifikacia())
            return null;
        ObservableList<NotificationData> result = FXCollections.observableArrayList();
        //ArrayOfHodnotenies notSeenH = hodnoteniePort.getByAttributeValue("bolo_videne", "false", new ArrayOfIds());
        ArrayOfHodnotenies all = hodnoteniePort.getAll();
        List<Hodnotenies> notSeenList = all.getHodnoteny().stream()
                .filter(item -> !item.isBoloVidene() && majitelPort.getAll().getMajitel().get(0).getHodnotaNotifikacie() >= item.getHodnota())
                .collect(Collectors.toList());

        System.out.println("Size of hodnotenia: " + notSeenList.size());
        for (Hodnotenies hodnotenies : notSeenList) {
            Zakaznik zakaznik = zakaznikPort.getById(hodnotenies.getZakaznikId());
            Kaviaren kaviaren = kaviarenPort.getById(hodnotenies.getKaviarenId());

            System.out.println(hodnotenies.getDatumPridania());

            result.add(new NotificationData(kaviaren.getName(), zakaznik.getName(),
                    String.valueOf(hodnotenies.getHodnota()),
                    hodnotenies.getDatumPridania()!= null ? String.valueOf(hodnotenies.getDatumPridania()) : ""));
        }

        return result;
    }

    public static class NotificationData{
        private final SimpleStringProperty cafeName;
        private final SimpleStringProperty customerName;
        private final SimpleStringProperty rate;
        private final SimpleStringProperty date;

        public NotificationData(String cafeName, String customerName, String rate, String date) {
            this.cafeName = new SimpleStringProperty(cafeName);
            this.customerName = new SimpleStringProperty(customerName);
            this.rate = new SimpleStringProperty(rate);
            this.date = new SimpleStringProperty(date);
        }

        public String getCafeName() {
            return cafeName.get();
        }

        public void setCafeName(String cafeName) {
            this.cafeName.set(cafeName);
        }

        public String getCustomerName() {
            return customerName.get();
        }

        public void setCustomerName(String customerName) {
            this.customerName.set(customerName);
        }

        public String getRate() {
            return rate.get();
        }

        public void setRate(String rate) {
            this.rate.set(rate);
        }

        public String getDate() {
            return date.get();
        }

        public void setDate(String date) {
            this.date.set(date);
        }
    }

    private void creteNewWindow(String fxmlPath, int cafeId) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlPath));
        try {
            Parent parent = (Parent) loader.load();

            if (fxmlPath.contains("CafeDetail")) {
                AdminCafeDetailPageController controller = loader.<AdminCafeDetailPageController>getController();
                System.out.println("Contains worker");
                controller.initialize(cafeId);
            }

            AnchorPane root = (AnchorPane) parent;
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Stage s = (Stage) notification_setting_button.getScene().getWindow();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
