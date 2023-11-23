import be.kdg.kollections.ArrayList;
import be.kdg.kollections.Kollections;
import be.kdg.kollections.LinkedList;
import be.kdg.kollections.List;
import be.kdg.model.Mes;
import be.kdg.model.MesFactory;

import java.util.Random;
import java.util.stream.Stream;

public class PerformanceTester {

    public static List<Mes> randomList(int n) {
        List<Mes> myList = new LinkedList<>();
        new Random().ints(n).forEach(i -> myList.add(MesFactory.newRandomMes()));
        return myList;
    }

    public static void compareArrayListAndLinkedList(int n) {
        List<Mes> myList = new ArrayList<>();
        long start = System.currentTimeMillis();
        Stream.generate(MesFactory::newEmptyMes).limit(n).forEach(mes -> myList.add(0, mes));
        long end = System.currentTimeMillis()-start;
        System.out.println("Adding " + n + " to arraylist: " + end);
        List<Mes> myLinkedList = new LinkedList<>();
        start = System.currentTimeMillis();
        Stream.generate(MesFactory::newEmptyMes).limit(n).forEach(mes -> myLinkedList.add(0, mes));
        end = System.currentTimeMillis()-start;
        System.out.println("Adding " + n + " to linkedlist: " + end);


        start = System.currentTimeMillis();
        for(int i = 0; i < n; i++) myList.get(myList.size()-1);
        end = System.currentTimeMillis()-start;
        System.out.println("Getting " + n + " from arraylist: " + end);
        start = System.currentTimeMillis();
        for(int i = 0; i < n ; i++) myLinkedList.get(myLinkedList.size()-1);
        end = System.currentTimeMillis()-start;
        System.out.println("Getting " + n + " from linkedlist: " + end);

    }

    public static void testSelectionSort() {
        Mes.teller = 0;
        for(int n = 1000; n < 20000; n += 1000){
            List<Mes> mesList = new ArrayList<>();
            Stream.generate(MesFactory::newRandomMes).limit(n).forEach(mesList::add);
            Kollections.selectionSort(mesList);
            System.out.println(n + ";" + Mes.teller);
            Mes.teller = 0;
        }
    }

    public static void testMergeSort() {
        Mes.teller = 0;
        for(int n = 1000; n < 20000; n += 1000){
            List<Mes> mesList = new ArrayList<>();
            Stream.generate(MesFactory::newRandomMes).limit(n).forEach(mesList::add);
            Kollections.mergeSort(mesList);
            System.out.println(n + ";" + Mes.teller);
            Mes.teller = 0;
        }
    }
}
