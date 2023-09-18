package be.kdg.model;

import java.time.LocalDate;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public class Mes {
    private String type;
    private LocalDate productieDag;
    private double lengte;
    private int hardheid;
    private String materiaal;
    private Lemmet lemmet;

    public Mes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet) {
        setType(type);
        setProductieDag(productieDag);
        setLemmet(lemmet);
        setLengte(lengte);
        setHardheid(hardheid);
        setMateriaal(materiaal);
    }

    public Mes(){
        this("Onbekend", LocalDate.MIN, 0, 0, "Onbekend", Lemmet.ONBEKEND);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type.isEmpty()) throw new IllegalArgumentException("Type mes mag niet leeg zijn");
        this.type = type;
    }

    public LocalDate getProductieDag() {
        return productieDag;
    }

    public void setProductieDag(LocalDate productieDag) {
        if(productieDag.isAfter(LocalDate.now())) throw new IllegalArgumentException("Datum moet voor vandaag zijn");
        this.productieDag = productieDag;
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        if(lengte < 0) throw new IllegalArgumentException("Lengte moet groter zijn dan 0");
        this.lengte = lengte;
    }

    public int getHardheid() {
        return hardheid;
    }

    public void setHardheid(int hardheid) {
        if(hardheid < 0) throw new IllegalArgumentException("Hardheid moet groter zijn dan 0");
        this.hardheid = hardheid;
    }

    public String getMateriaal() {
        return materiaal;
    }

    public void setMateriaal(String materiaal) {
        if(materiaal.isEmpty()) throw new IllegalArgumentException("Het materiaal mag niet leeg zijn");
        this.materiaal = materiaal;
    }

    public Lemmet getLemmet() {
        return lemmet;
    }

    public void setLemmet(Lemmet lemmet) {
        this.lemmet = lemmet;
    }
}
