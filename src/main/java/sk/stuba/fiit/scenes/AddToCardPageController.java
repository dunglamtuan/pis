package sk.stuba.fiit.scenes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.Team076NavstevaPortType;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.Team076NavstevaService;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.ArrayOfIds;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.ArrayOfNavstevas;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.Navsteva;
import sk.stuba.fiit.labss2.pis.students.team076navsteva.types.Navstevas;

import java.util.List;
import java.util.stream.Collectors;

public class AddToCardPageController {

    private int kaviarenId;

    @FXML
    TextField cardid_textfield;

    @FXML
    Button confirm_button;

    @FXML
    private void initialize(){
        confirm_button.setOnMouseClicked(event -> {
            String cardid_input = cardid_textfield.getText();
            addTCard(cardid_input);
        });
    }

    private void addTCard(String cardid){
        Team076NavstevaService navstevaService = new Team076NavstevaService();
        Team076NavstevaPortType port = navstevaService.getTeam076NavstevaPort();

        ArrayOfNavstevas navstevas = port.getByAttributeValue("cislo_karty", cardid, new ArrayOfIds());
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
            //TODO - set navstevnik id
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

    public void setKaviarenId(int kaviarenId) {
        this.kaviarenId = kaviarenId;
    }
}



