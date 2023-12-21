import be.kdg.kollections.lists.ArrayList;
import be.kdg.kollections.Kollections;
import be.kdg.kollections.lists.List;
import be.kdg.model.Lemmet;
import be.kdg.model.Mes;
import be.kdg.model.MesFactory;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Vincent Verboven
 * 23/11/2023
 */
public class Demo_8 {
    public static void main(String[] args) {
        System.out.println("Leeg mes:");
        System.out.println(MesFactory.newEmptyMes());
        System.out.println("Gevuld mes:");
        System.out.println(MesFactory.newFilledMes("Koksmes", LocalDate.of(2015, 3,10),20.5, 58, "Roestvrij staal", Lemmet.NORMAAL));
        System.out.println("30 random messen:");
        Stream.generate(MesFactory::newRandomMes).limit(30).forEach(System.out::println);
        System.out.println("Random list:");
        List<Mes> messenList = PerformanceTester.randomList(15);
        for(int i = 0; i < messenList.size(); i++){
            System.out.println(messenList.get(i));
        }

        PerformanceTester.compareArrayListAndLinkedList(20000);

        List<Mes> mesList = PerformanceTester.randomList(30);
        List<Mes> newList = Kollections.selectionSort(mesList);
        System.out.println("Gesorteerde list:");
        for(int i = 0; i < newList.size(); i++){
            System.out.println(newList.get(i));
        }

        System.out.println("Merge sort:");
        Kollections.mergeSort(mesList);
        for(int i = 0; i < mesList.size(); i++){
            System.out.print(mesList.get(i));
        }

        PerformanceTester.testSelectionSort();
        PerformanceTester.testMergeSort();
        List<Mes> quicksortList = new ArrayList<>();
        Stream.generate(MesFactory::newRandomMes).limit(30).forEach(quicksortList::add);
        Kollections.quickSort(quicksortList);
        System.out.println("Quicksort:");
        for(int i = 0; i < quicksortList.size(); i++){
            System.out.print(quicksortList.get(i));
        }

        System.out.println("Binary search voor element 3: " + Kollections.binarySearch(quicksortList, quicksortList.get(3)));
        System.out.println("Linear search voor element 3: " + Kollections.lineairSearch(quicksortList, quicksortList.get(3)));
        System.out.println("Binary search voor onbestaand element: " + Kollections.binarySearch(quicksortList, MesFactory.newRandomMes()));
        System.out.println("Linaer search voor onbestaand element: " + Kollections.binarySearch(quicksortList, MesFactory.newRandomMes()));

        Mes.equalsCounter = 0;
        PerformanceTester.compareListMapToHashMap(1000);

        PerformanceTester.compareArraySetToTreeSet();
    }
}
