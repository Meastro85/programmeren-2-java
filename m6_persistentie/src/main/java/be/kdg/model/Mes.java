package be.kdg.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Mes implements Comparable<Mes>, Serializable {
    @Serial
    private static final long serialVersionUID = 2023_10_23L;
    private int id;
    private String type;
    private transient LocalDate productieDag;
    private transient double lengte;
    private transient int hardheid;
    private String materiaal;
    private Lemmet lemmet;

    public Mes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet) {
        this(type, productieDag, lengte, hardheid, materiaal, lemmet, -1);
    }

    public Mes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet, int id) {
        setType(type);
        setProductieDag(productieDag);
        setLemmet(lemmet);
        setLengte(lengte);
        setHardheid(hardheid);
        setMateriaal(materiaal);
        this.id = id;
    }

    public Mes() {
        this("Onbekend", LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND, -1);
    }

    //region Setters

    public void setType(String type) {
        if (type.isEmpty()) throw new IllegalArgumentException("Type mes mag niet leeg zijn");
        this.type = type;
    }

    public void setProductieDag(LocalDate productieDag) {
        if (productieDag.isAfter(LocalDate.now())) throw new IllegalArgumentException("Datum moet voor vandaag zijn");
        this.productieDag = productieDag;
    }

    public void setLengte(double lengte) {
        if (lengte < 0) throw new IllegalArgumentException("Lengte moet groter zijn dan 0");
        this.lengte = lengte;
    }

    public void setHardheid(int hardheid) {
        if (hardheid < 0) throw new IllegalArgumentException("Hardheid moet groter zijn dan 0");
        this.hardheid = hardheid;
    }

    public void setMateriaal(String materiaal) {
        if (materiaal.isEmpty()) throw new IllegalArgumentException("Het materiaal mag niet leeg zijn");
        this.materiaal = materiaal;
    }

    public void setLemmet(Lemmet lemmet) {
        this.lemmet = lemmet;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    //endregion

    //region Getters

    public String getType() {
        return type;
    }

    public LocalDate getProductieDag() {
        return productieDag;
    }

    public Lemmet getLemmet() {
        return lemmet;
    }

    public double getLengte() {
        return lengte;
    }

    public int getHardheid() {
        return hardheid;
    }

    public String getMateriaal() {
        return materiaal;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mes mes = (Mes) o;
        return Double.compare(lengte, mes.lengte) == 0 && hardheid == mes.hardheid && Objects.equals(type, mes.type) && Objects.equals(productieDag, mes.productieDag) && Objects.equals(materiaal, mes.materiaal) && lemmet == mes.lemmet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, productieDag, lengte, hardheid, materiaal, lemmet);
    }

    @Override
    public int compareTo(Mes o) {
        return Comparator.comparing(Mes::getType)
                .thenComparingDouble(Mes::getLengte)
                .thenComparingInt(Mes::getHardheid)
                .thenComparing(Mes::getProductieDag)
                .thenComparing(Mes::getMateriaal)
                .thenComparing(Mes::getLemmet)
                .compare(this, o);
    }

    @Override
    public String toString() {
        return String.format("Type mes: %-15s Geproduceerd op: %-12s Lemmet type: %-15s Gemaakt uit: %-30s met hardheid %-2d HRC    Lengte van het mes: %-5.2f cm\n",
                getType(),
                getProductieDag().toString(),
                getLemmet().toString(),
                getMateriaal(),
                getHardheid(),
                getLengte());
    }
}
