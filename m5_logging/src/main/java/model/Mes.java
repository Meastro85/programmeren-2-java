package model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Mes implements Comparable<Mes> {
    private String type;
    private LocalDate productieDag;
    private double lengte;
    private int hardheid;
    private String materiaal;
    private Lemmet lemmet;
    public static final Logger logger = Logger.getLogger("be.kdg.model.Mes");

    public Mes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet) {
        setType(type);
        setProductieDag(productieDag);
        setLemmet(lemmet);
        setLengte(lengte);
        setHardheid(hardheid);
        setMateriaal(materiaal);
    }

    public Mes() {
        this("Onbekend", LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND);
    }

    //region Setters

    public void setType(String type) {
        if (type.isEmpty()) logger.log(Level.SEVERE,String.format("Type van mes %s mag niet naar een lege waarde veranderen.", this.getType()));
        this.type = type;
    }

    public void setProductieDag(LocalDate productieDag) {
        if (productieDag.isAfter(LocalDate.now())) logger.log(Level.SEVERE, String.format("Productiedag %s van mes %s mag niet na vandaag zijn.",productieDag, this.getType()));
        this.productieDag = productieDag;
    }

    public void setLengte(double lengte) {
        if (lengte < 0) logger.log(Level.SEVERE, String.format("Lengte %f van mes %s mag niet kleiner zijn dan 0.",lengte, this.getType()));
        this.lengte = lengte;
    }

    public void setHardheid(int hardheid) {
        if (hardheid < 0) logger.log(Level.SEVERE, String.format("Hardheid %d van mes %s mag niet kleiner zijn dan 0.", hardheid, this.getType()));
        this.hardheid = hardheid;
    }

    public void setMateriaal(String materiaal) {
        if (materiaal.isEmpty()) logger.log(Level.SEVERE, String.format("Materiaal voor mes %s mag niet leeg zijn.", this.getType()));
        this.materiaal = materiaal;
    }

    public void setLemmet(Lemmet lemmet) {
        this.lemmet = lemmet;
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
