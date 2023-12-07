package be.kdg.model;

import java.time.LocalDate;
import java.util.*;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Messen {

    private Set<Mes> messenTreeSet;

    public Messen(){
        messenTreeSet = new TreeSet<>();
    }

    public boolean add(Mes mes){
        return messenTreeSet.add(mes);
    }

    public boolean remove(String type, LocalDate productieDag, Lemmet lemmet, double lengte, int hardheid, String materiaal ){
        for (Iterator<Mes> iterator = messenTreeSet.iterator(); iterator.hasNext(); ) {
            Mes next =  iterator.next();
            if(Objects.equals(next.getType(), type) &&
                    next.getProductieDag().isEqual(productieDag) &&
                    next.getLemmet() == lemmet &&
                    next.getLengte() == lengte &&
                    next.getHardheid() == hardheid &&
                    Objects.equals(next.getMateriaal(), materiaal)){
                return messenTreeSet.remove(next);
            }
        }
        return false;
    }

    public Mes search(String type, LocalDate productieDag, Lemmet lemmet, double lengte, int hardheid, String materiaal){
        for (Mes mes : messenTreeSet) {
            if(mes.equals(new Mes(type, productieDag, lengte, hardheid, materiaal, lemmet))) return mes;
        }
        return null;
    }

    public int getSize(){
        return messenTreeSet.size();
    }

    //region Sorting Methods
    private List<Mes> sortList(Comparator<Mes> comparator){
        List<Mes> mesList = new ArrayList<>(messenTreeSet);
        mesList.sort(comparator);
        return mesList;
    }

    public List<Mes> sortedOnType(){
        return sortList(new TypeComparator());
    }

    public List<Mes> sortedOnProductieDag(){
        return sortList(new ProductieDagComparator());
    }

    public List<Mes> sortedOnLengte(){
        return sortList(new LengteComparator());
    }

    public List<Mes> sortedOnHardheid(){
        return sortList(new HardheidComparator());
    }

    public List<Mes> sortedOnMateriaal(){
        return sortList(new MateriaalComparator());
    }

    public List<Mes> sortedOnLemmet(){
        return sortList(new LemmetComparator());
    }
    //endregion

    //region Comparator Classes
    private static class TypeComparator implements Comparator<Mes> {

        @Override
        public int compare(Mes o1, Mes o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }

    private static class ProductieDagComparator implements Comparator<Mes>{

        @Override
        public int compare(Mes o1, Mes o2) {
            return o1.getProductieDag().compareTo(o2.getProductieDag());
        }
    }

    private static class LengteComparator implements Comparator<Mes>{

        @Override
        public int compare(Mes o1, Mes o2) {
            return Double.compare(o1.getLengte(), o2.getLengte());
        }
    }

    private static class HardheidComparator implements Comparator<Mes>{

        @Override
        public int compare(Mes o1, Mes o2) {
            return o1.getHardheid() - o2.getHardheid();
        }
    }

    private static class MateriaalComparator implements Comparator<Mes>{

        @Override
        public int compare(Mes o1, Mes o2) {
            return o1.getMateriaal().compareTo(o2.getMateriaal());
        }
    }

    private static class LemmetComparator implements Comparator<Mes>{

        @Override
        public int compare(Mes o1, Mes o2) {
            return o1.getLemmet().toString().compareTo(o2.getLemmet().toString());
        }
    }
    //endregion

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Mes mes : messenTreeSet) {
           string.append(mes);
        }
        return string.toString();
    }
}
