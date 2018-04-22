package sk.stuba.fiit.scenes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikPortType;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.Team076ZakaznikService;
import sk.stuba.fiit.labss2.pis.students.team076zakaznik.types.Zakaznik;

public class UserRegistrationPageController {

    @FXML
    TextField name_textfield;

    @FXML
    TextField email_textfield;

    @FXML
    TextField cardid_textfield;

    @FXML
    Button registration_button;

    @FXML
    TextField pass_textfield;

    @FXML
    private void initialize(){

        registration_button.setOnMouseClicked(event ->{
            String nameInput =  name_textfield.getText();
            String email_input = email_textfield.getText();
            String cardd_input = cardid_textfield.getText();
            String pass = pass_textfield.getText();

            registerNewUser(nameInput, email_input, cardd_input, pass);
        });
    }

    private void registerNewUser(String name, String email, String cardid, String pass){
        Team076ZakaznikService service = new Team076ZakaznikService();
        Team076ZakaznikPortType port = service.getTeam076ZakaznikPort();
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setCisloKarty(Integer.valueOf(cardid));
        zakaznik.setName(name);
        zakaznik.setEmail(email);
        zakaznik.setHeslo(pass);

        port.insert("076", "GS3kMb", zakaznik);
    }

}
