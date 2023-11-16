package be.kdg.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.*;

/**
 * Vincent Verboven
 * 18/09/2023
 */
@XmlRootElement
public class Messen {

    private ArrayList<Mes> messenList;

    public Messen(){
        messenList = new ArrayList<>();
    }

    public boolean add(Mes mes){
        return messenList.add(mes);
    }

    public boolean remove(String type, LocalDate productieDag, Lemmet lemmet, double lengte, int hardheid, String materiaal ){
        for (Iterator<Mes> iterator = messenList.iterator(); iterator.hasNext(); ) {
            Mes next =  iterator.next();
            if(Objects.equals(next.getType(), type) &&
                    next.getProductieDag().isEqual(productieDag) &&
                    next.getLemmet() == lemmet &&
                    next.getLengte() == lengte &&
                    next.getHardheid() == hardheid &&
                    Objects.equals(next.getMateriaal(), materiaal)){
                return messenList.remove(next);
            }
        }
        return false;
    }

    public Mes search(String type, LocalDate productieDag, Lemmet lemmet, double lengte, int hardheid, String materiaal){
        for (Mes mes : messenList) {
            if(mes.equals(new Mes(type, productieDag, lengte, hardheid, materiaal, lemmet))) return mes;
        }
        return null;
    }

    public int getSize(){
        return messenList.size();
    }

    public ArrayList<Mes> getMessenList() {
        return messenList;
    }

    @XmlElement(name = "messen")
    public void setMessenList(ArrayList<Mes> messenList) {
        this.messenList = messenList;
    }

    //region Sorting Methods
    private List<Mes> sortList(Comparator<Mes> comparator){
        List<Mes> mesList = new ArrayList<>(messenList);
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
        for (Mes mes : messenList) {
           string.append(mes);
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messen messen = (Messen) o;

        for(Mes mes : this.messenList){
            if(messen.search(mes.getType(), mes.getProductieDag(), mes.getLemmet(), mes.getLengte(), mes.getHardheid(), mes.getMateriaal()) == null){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return messenList != null ? messenList.hashCode() : 0;
    }
}
