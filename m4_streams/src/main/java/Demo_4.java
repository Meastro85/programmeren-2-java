import data.Data;
import model.Lemmet;
import model.Mes;
import model.Messen;
import utils.MesFunctions;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Vincent Verboven
 * 9/10/2023
 */
public class Demo_4 {
    public static void main(String[] args) {
        Messen messenLijst = new Messen();
        Data.getData().forEach(messenLijst::add);
        System.out.println("Toepassing 3 keer gesorteerd op andere waarde.");
        System.out.println("gesorteerd op hardheid");
        messenLijst.sortedBy(Mes::getHardheid).forEach(System.out::println);
        System.out.println("gesorteerd op type");
        System.out.println(messenLijst.sortedBy(Mes::getType));
        System.out.println("gesorteerd op lemmet");
        System.out.println(messenLijst.sortedBy(Mes::getLemmet));
        List<Mes> mesList =  messenLijst.sortedBy(Mes::getType);
        System.out.println("Toepassing 3 keer filteredList met telkens een ander Predicate.");
        System.out.println("Filtered op hardheid hoger dan 60 HRC");
        System.out.println(MesFunctions.filteredList(mesList, mes -> mes.getHardheid() > 60));
        System.out.println("Filtered op lengte langer dan 20 cm");
        System.out.println(MesFunctions.filteredList(mesList, mes -> mes.getLengte() > 20));
        System.out.println("Filtered op lemmet type Schaapsvoet");
        System.out.println(MesFunctions.filteredList(mesList, mes -> mes.getLemmet() == Lemmet.SCHAAPSVOET));

        System.out.println("Gemiddelde berekening");
        System.out.println("Gemiddelde op hardheid");
        System.out.println(MesFunctions.average(mesList, Mes::getHardheid));
        System.out.println("Gemiddelde lengte");
        System.out.println(MesFunctions.average(mesList, Mes::getLengte));

        System.out.println("Aantal messen met lengte < 20");
        System.out.println(MesFunctions.countIf(mesList, mes -> mes.getLengte() < 20));
        System.out.println("Aantal messen met hardheid < 60");
        System.out.println(MesFunctions.countIf(mesList, mes -> mes.getHardheid() < 60));

        List<Mes> dataList = Data.getData();
        System.out.print("Aantal messen gemaakt na 2022: ");
        System.out.println(dataList.stream().filter(mes -> mes.getProductieDag().isAfter(LocalDate.of(2022,1,1))).count());
        System.out.println("Gesorteerd op hardheid en lengte:");
        dataList.stream().sorted(Comparator.comparing(Mes::getHardheid).thenComparing(Mes::getLengte)).forEach(System.out::println);
        System.out.println("Alle types in hoofdletters, omgekeerd gesorteerd en zonder dubbels");
        System.out.println(dataList.stream().map(mes -> mes.getType().toUpperCase()).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.joining(", ")));
        System.out.println("Een willekeurig mes met meer dan 60 HRC");
        System.out.println(dataList.stream().filter(mes -> mes.getHardheid() > 60).findAny().get());
        System.out.print("De kampioen in lengte: ");
        System.out.println(dataList.stream().max(Comparator.comparing(Mes::getLengte)).get());
        System.out.print("De kampioen in hardheid: ");
        System.out.println(dataList.stream().max(Comparator.comparing(Mes::getHardheid)).get());
        System.out.println("List met gesorteerde messen types die beginnen met 'S'");
        System.out.println(dataList.stream().filter(mes -> mes.getType().charAt(0) == 'S').sorted(Comparator.comparing(Mes::getType)).map(Mes::getType).collect(Collectors.toList()));
        System.out.println("sublist met Messen gemaakt VOOR 2020:");
        Map<Boolean, List<Mes>> map = dataList.stream().collect(Collectors.partitioningBy(mes -> mes.getProductieDag().isBefore(LocalDate.of(2020,1,1))));
        System.out.println(map.get(true));
        System.out.println("sublist met Messen gemaakt NA 2020");
        System.out.println(map.get(false));
        System.out.println("Alle messen gegroepeerd per type:");
        Map<Lemmet, List<Mes>> lemmetMap = dataList.stream().sorted(Comparator.comparing(Mes::getType)).collect(Collectors.groupingBy(Mes::getLemmet));
        lemmetMap.keySet().forEach(k -> System.out.printf("%-20s: %s\n", k.toString(), lemmetMap.get(k).stream().map(Mes::getType).collect(Collectors.joining(" "))));
        System.out.println("Remove test");
        System.out.println(messenLijst.remove("Jachtmes",LocalDate.of(2002, 10,17),Lemmet.DROPPOINT,12.4, 58,"Roestvrij staal"));
        System.out.println(messenLijst);
        System.out.println("Search test");
        System.out.println(messenLijst.search("Jachtmes", LocalDate.of(2002,10,17), Lemmet.DROPPOINT, 12.4, 58, "Roestvrij staal"));
        System.out.println(messenLijst.search("Broodmes", LocalDate.of(2019, 9,5), Lemmet.SCHAAPSVOET, 22.2, 62, "High Carbon Steel"));
    }
}
