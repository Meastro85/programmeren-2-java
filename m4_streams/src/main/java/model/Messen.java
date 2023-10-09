package model;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Messen {

    private final Set<Mes> messenTreeSet;

    public Messen(){
        messenTreeSet = new TreeSet<>();
    }

    public boolean add(Mes mes){
        return messenTreeSet.add(mes);
    }

    public boolean remove(String type, LocalDate productieDag, Lemmet lemmet, double lengte, int hardheid, String materiaal ){
        return messenTreeSet.removeIf(mes -> mes.equals(new Mes(type, productieDag, lengte, hardheid, materiaal, lemmet)));
    }

    public Mes search(String type, LocalDate productieDag, Lemmet lemmet, double lengte, int hardheid, String materiaal){
        return messenTreeSet.stream().filter(mes -> mes.equals(new Mes(type, productieDag, lengte, hardheid, materiaal, lemmet))).findAny().orElse(null);
    }

    public int getSize(){
        return messenTreeSet.size();
    }

    public List<Mes> sortedBy(Function<Mes, Comparable> function){
        List<Mes> mesList = new ArrayList<>(messenTreeSet);
        mesList.sort(Comparator.comparing(function));
        return mesList;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Mes mes : messenTreeSet) {
           string.append(mes);
        }
        return string.toString();
    }
}
