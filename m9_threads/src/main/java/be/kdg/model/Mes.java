package be.kdg.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public final class Mes implements Comparable<Mes> {
    private final String type;
    private final LocalDate productieDag;
    private final double lengte;
    private final int hardheid;
    private final String materiaal;
    private final Lemmet lemmet;

    public Mes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet) {
        this.type = type;
        this.productieDag = productieDag;
        this.lemmet = lemmet;
        this.lengte = lengte;
        this.hardheid = hardheid;
        this.materiaal = materiaal;
    }

    public Mes() {
        this("Onbekend", LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND);
    }

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
