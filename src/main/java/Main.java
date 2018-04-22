import sk.stuba.fiit.*;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenPortType;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.Team076KaviarenService;
import sk.stuba.fiit.labss2.pis.students.team076kaviaren.types.Kaviaren;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Team076KaviarenService service = new Team076KaviarenService();
        Team076KaviarenPortType port = service.getTeam076KaviarenPort();
        Kaviaren byId = port.getById(123);
        if (byId == null)
            System.out.println("byID is null");


    }
}
