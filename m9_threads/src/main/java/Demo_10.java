import be.kdg.model.Lemmet;
import be.kdg.model.Mes;
import be.kdg.model.MesFactory;
import be.kdg.threading.MesAttacker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Vincent Verboven
 * 7/12/2023
 */
public class Demo_10 {
    public static void main(String[] args) {
        List<Mes> mesList = Stream.generate(MesFactory::newRandomMes).limit(1000).collect(Collectors.toList());
        MesAttacker mesAttacker1 = new MesAttacker(mesList, mes -> mes.getLemmet() == Lemmet.SCHAAPSVOET);
        MesAttacker mesAttacker2 = new MesAttacker(mesList, mes -> mes.getLengte() < 20);
        MesAttacker mesAttacker3 = new MesAttacker(mesList, mes -> mes.getLemmet() == Lemmet.KLIP);
        Thread mesThread1 = new Thread(mesAttacker1);
        Thread mesThread2 = new Thread(mesAttacker2);
        Thread mesThread3 = new Thread(mesAttacker3);
        mesThread1.start();
        mesThread2.start();
        mesThread3.start();

        System.out.println("Na uitzuivering:");
        System.out.println("Aantal Schaapsvoet: " + mesList.stream().filter(mes -> mes.getLemmet() == Lemmet.SCHAAPSVOET).count());
        System.out.println("Aantal kleiner dan 20: " + mesList.stream().filter(mes -> mes.getLengte() < 20).count());
        System.out.println("Aantal klip: " + mesList.stream().filter(mes -> mes.getLemmet() == Lemmet.KLIP).count());
    }
}
