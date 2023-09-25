package be.kdg.model;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

/**
 * Vincent Verboven
 * 18/09/2023
 * @author Vincent Verboven
 * @version 1.0
 * @see <a href="https://nl.wikipedia.org/wiki/Mes_(voorwerp)">Onderwerp</a>
 */
public class Mes implements Comparable<Mes> {
    private String type;
    private LocalDate productieDag;
    private double lengte;
    private int hardheid;
    private String materiaal;
    private Lemmet lemmet;

    /**
     * Dit is de hoofd constructor om een mes aan te maken met specifieke eigenschappen
     * @param type Het type mes
     * @param productieDag De dag waarop het mes geproduceerd is
     * @param lengte De lengte van het mes
     * @param hardheid De hardheid van het materiaal
     * @param materiaal Het materiaal waaruit het blad gemaakt is
     * @param lemmet Het soort lemmet
     */
    public Mes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet) {
        setType(type);
        setProductieDag(productieDag);
        setLemmet(lemmet);
        setLengte(lengte);
        setHardheid(hardheid);
        setMateriaal(materiaal);
    }

    /**
     * Dit is een generieke constructor om een mes aan te maken zonder specifieke eigenschappen
     */
    public Mes() {
        this("Onbekend", LocalDate.of(1,1,1), 0, 0, "Onbekend", Lemmet.ONBEKEND);
    }

    //region Setters

    /**
     * Methode om het type te veranderen
     * @param type mes
     */
    public void setType(String type) {
        if (type.isEmpty()) throw new IllegalArgumentException("Type mes mag niet leeg zijn");
        this.type = type;
    }

    /**
     * Methode om de productiedag te veranderen
     * @param productieDag productie dag van het mes
     */
    public void setProductieDag(LocalDate productieDag) {
        if (productieDag.isAfter(LocalDate.now())) throw new IllegalArgumentException("Datum moet voor vandaag zijn");
        this.productieDag = productieDag;
    }

    /**
     * Methode om de lengte van het mes te veranderen
     * @param lengte van het mes
     */
    public void setLengte(double lengte) {
        if (lengte < 0) throw new IllegalArgumentException("Lengte moet groter zijn dan 0");
        this.lengte = lengte;
    }

    /**
     * Methode om de hardheid van het materiaal te veranderen
     * @param hardheid van het materiaal
     */
    public void setHardheid(int hardheid) {
        if (hardheid < 0) throw new IllegalArgumentException("Hardheid moet groter zijn dan 0");
        this.hardheid = hardheid;
    }

    /**
     * Methode om het materiaal te veranderen
     * @param materiaal van het mes
     */
    public void setMateriaal(String materiaal) {
        if (materiaal.isEmpty()) throw new IllegalArgumentException("Het materiaal mag niet leeg zijn");
        this.materiaal = materiaal;
    }

    /**
     * Methode om het lemmet te veranderen
     * @param lemmet van het mes
     * @see Lemmet
     */
    public void setLemmet(Lemmet lemmet) {
        this.lemmet = lemmet;
    }

    //endregion

    //region Getters

    /**
     * Methode om het type terug te krijgen
     * @return type mes
     */
    public String getType() {
        return type;
    }

    /**
     * Methode om de productie dag terug te krijgen
     * @return productie dag van het mes
     */
    public LocalDate getProductieDag() {
        return productieDag;
    }

    /**
     * Methode om het lemmet terug te krijgen
     * @return lemmet van het mes
     * @see Lemmet
     */
    public Lemmet getLemmet() {
        return lemmet;
    }

    /**
     * Methode om het lengte van het mes te krijgen
     * @return lengte van het mes
     */
    public double getLengte() {
        return lengte;
    }

    /**
     * Methode om de hardheid van het materiaal te krijgen
     * @return hardheid van het materiaal
     */
    public int getHardheid() {
        return hardheid;
    }

    /**
     * Methode om het materiaal van het mes te krijgen
     * @return materiaal van het mes
     */
    public String getMateriaal() {
        return materiaal;
    }

    //endregion

    /**
     * Methode om het mes object te vergelijken met een ander object
     * @param o een object (bij voorkeur Mes)
     * @return true als het hetzelfde object is, anders false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mes mes = (Mes) o;
        return Double.compare(lengte, mes.lengte) == 0 && hardheid == mes.hardheid && Objects.equals(type, mes.type) && Objects.equals(productieDag, mes.productieDag) && Objects.equals(materiaal, mes.materiaal) && lemmet == mes.lemmet;
    }

    /**
     * Methode om de hashcode van het object te krijgen
     * @return de hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, productieDag, lengte, hardheid, materiaal, lemmet);
    }

    /**
     * Methode om het Mes te vergelijken met een ander Mes
     *
     * @param o Het mes om mee te vergelijken
     * @return een int afhangend van de verschillende waarden tussen de messen
     */
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

    /**
     * Methode om het mes als string terug te krijgen
     * @return een string van het mes
     */
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
