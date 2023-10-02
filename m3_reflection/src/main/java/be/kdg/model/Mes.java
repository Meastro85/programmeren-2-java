package be.kdg.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Mes extends Steekwapen implements Comparable<Mes> {
    private double lengte;
    private Lemmet lemmet;

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

    public void setLengte(double lengte) {
        if (lengte < 0) throw new IllegalArgumentException("Lengte moet groter zijn dan 0");
        this.lengte = lengte;
    }

    public void setLemmet(Lemmet lemmet) {
        this.lemmet = lemmet;
    }

    //endregion

    //region Getters

    public Lemmet getLemmet() {
        return lemmet;
    }

    public double getLengte() {
        return lengte;
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
        return String.format("%s Lemmet type: %-15s Lengte van het mes: %-5.2f cm", super.toString(), getLemmet(), getLengte());
    }
}
