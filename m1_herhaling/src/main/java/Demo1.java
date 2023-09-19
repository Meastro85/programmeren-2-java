import be.kdg.data.Data;
import be.kdg.model.Lemmet;
import be.kdg.model.Mes;
import be.kdg.model.Messen;

import java.time.LocalDate;
import java.util.List;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Demo1 {
    public static void main(String[] args) {
        List<Mes> data = Data.getData();
        Messen messenLijst = new Messen();
        for (Mes mes : data) {
            messenLijst.add(mes);
        }
        System.out.println(messenLijst);

        System.out.println("Dubbel object test:");
        messenLijst.add(new Mes("Jachtmes", LocalDate.of(2002, 10,17),12.4, 58, "Roestvrij staal", Lemmet.DROPPOINT));
        System.out.println(messenLijst);

        System.out.println("Search test:");
        System.out.println(messenLijst.search("Jachtmes",LocalDate.of(2002, 10,17),Lemmet.DROPPOINT,12.4, 58,"Roestvrij staal"));

        System.out.println("Remove test:");
        System.out.println(messenLijst.remove("Jachtmes",LocalDate.of(2002, 10,17),Lemmet.DROPPOINT,12.4, 58,"Roestvrij staal"));
        System.out.println(messenLijst);

        System.out.println("Getsize test:");
        System.out.println(messenLijst.getsize());

        System.out.println("Sorting test:");
        System.out.println("Gesorteerd op materiaal:");
        System.out.println(messenLijst.sortedOnMateriaal());
        System.out.println("Gesorteerd op hardheid:");
        System.out.println(messenLijst.sortedOnHardheid());
        System.out.println("Gesorteerd op lemmet:");
        System.out.println(messenLijst.sortedOnLemmet());
        System.out.println("Gesorteerd op productiedag:");
        System.out.println(messenLijst.sortedOnProductieDag());
        System.out.println("Gesorteerd op lengte:");
        System.out.println(messenLijst.sortedOnLengte());
        System.out.println("Gesorteerd op type:");
        System.out.println(messenLijst.sortedOnType());

        System.out.println("Lege constructor test:");
        messenLijst.add(new Mes());
        System.out.println(messenLijst);
        System.out.println("Exception test:");
        try{
            messenLijst.add(new Mes("",LocalDate.of(2000,10,20),12.5,-10,"", Lemmet.ONBEKEND));
        } catch(IllegalArgumentException ex){
            System.out.println(ex);
        }

    }

}
