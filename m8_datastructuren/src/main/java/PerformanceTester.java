import be.kdg.kollections.lists.ArrayList;
import be.kdg.kollections.Kollections;
import be.kdg.kollections.lists.LinkedList;
import be.kdg.kollections.lists.List;
import be.kdg.kollections.maps.HashMap;
import be.kdg.kollections.maps.ListMap;
import be.kdg.kollections.maps.Map;
import be.kdg.kollections.sets.ArraySet;
import be.kdg.kollections.sets.TreeSet;
import be.kdg.model.Lemmet;
import be.kdg.model.Mes;
import be.kdg.model.MesFactory;

import java.time.LocalDate;
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
        Mes.compareTeller = 0;
        for(int n = 1000; n < 20000; n += 1000){
            List<Mes> mesList = new ArrayList<>();
            Stream.generate(MesFactory::newRandomMes).limit(n).forEach(mesList::add);
            Kollections.selectionSort(mesList);
            System.out.println(n + ";" + Mes.compareTeller);
            Mes.compareTeller = 0;
        }
    }

    public static void testMergeSort() {
        Mes.compareTeller = 0;
        for(int n = 1000; n < 20000; n += 1000){
            List<Mes> mesList = new ArrayList<>();
            Stream.generate(MesFactory::newRandomMes).limit(n).forEach(mesList::add);
            Kollections.mergeSort(mesList);
            System.out.println(n + ";" + Mes.compareTeller);
            Mes.compareTeller = 0;
        }
    }

    public static void compareListMapToHashMap(int mapSize){
        Map<Mes, String> hashMap = new HashMap<>();
        fillMap(hashMap, mapSize);
        Map<Mes, String> listMap = new ListMap<>();
        fillMap(listMap, mapSize);
        long start = System.nanoTime();
        int counter = 0;
        for(int i = 0; i < 1000; i++){
            if(counter == mapSize){
                counter = 0;
            }
            listMap.get(MesFactory.newFilledMes("Mes" + counter++, LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND));
        }
        long end = System.nanoTime();
        System.out.printf("ListMap: n = %d, equalscount = %d, nanosec = %d\n", mapSize, Mes.equalsTeller, end - start);
        Mes.equalsTeller = 0;
        start = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            if(counter == mapSize){
                counter = 0;
            }
            hashMap.get(MesFactory.newFilledMes("Mes" + counter++, LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND));
        }
        end = System.nanoTime();
        System.out.printf("HashMap: n = %d, equalscount = %d, nanosec = %d\n", mapSize, Mes.equalsTeller, end - start);
        Mes.equalsTeller = 0;
    }

    private static void fillMap(Map<Mes, String> map, int mapSize){
        for(int i = 0; i < mapSize; i++){
            Mes mes = MesFactory.newFilledMes("Mes" + i, LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND);
            map.put(mes, "Mes van type " + mes.getType());
        }
    }

    public static void compareArraySetToTreeSet(){
        ArraySet<Mes> arraySet = new ArraySet<>();
        long start = System.nanoTime();
        Stream.generate(MesFactory::newRandomMes).limit(1000).forEach(arraySet::add);
        long end = System.nanoTime();
        System.out.printf("Arrayset: n = 1000, equalscount = %d, comparecount = %d, nanosec = %d\n", Mes.equalsTeller, Mes.compareTeller, end - start);
        Mes.equalsTeller = 0;
        Mes.compareTeller = 0;
        TreeSet<Mes> mesTreeSet = new TreeSet<>();
        start = System.nanoTime();
        Stream.generate(MesFactory::newRandomMes).limit(1000).forEach(mesTreeSet::add);
        end = System.nanoTime();
        System.out.printf("Treeset: n = 1000, equalscount = %d, comparecount = %d, nanosec = %d\n", Mes.equalsTeller, Mes.compareTeller, end - start);
    }

}
