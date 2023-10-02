package be.kdg.model;

import be.kdg.reflection.CanRun;

import java.time.LocalDate;

/**
 * Vincent Verboven
 * 2/10/2023
 */
public class Steekwapen {
    protected String type;
    protected LocalDate productieDag;
    protected int hardheid;
    protected String materiaal;

    @CanRun()
    public void setType(String type) {
        if (type.isEmpty()) throw new IllegalArgumentException("Type mes mag niet leeg zijn");
        this.type = type;
    }

    public void setProductieDag(LocalDate productieDag) {
        if (productieDag.isAfter(LocalDate.now())) throw new IllegalArgumentException("Datum moet voor vandaag zijn");
        this.productieDag = productieDag;
    }

    public void setHardheid(int hardheid) {
        if (hardheid < 0) throw new IllegalArgumentException("Hardheid moet groter zijn dan 0");
        this.hardheid = hardheid;
    }

    @CanRun("Stainless steel")
    public void setMateriaal(String materiaal) {
        if (materiaal.isEmpty()) throw new IllegalArgumentException("Het materiaal mag niet leeg zijn");
        this.materiaal = materiaal;
    }

    public String getType() {
        return type;
    }

    public LocalDate getProductieDag() {
        return productieDag;
    }

    public int getHardheid() {
        return hardheid;
    }

    public String getMateriaal() {
        return materiaal;
    }

    @Override
    public String toString() {
        return String.format("Type mes: %-15s Geproduceerd op: %-12s Gemaakt uit: %-30s met hardheid %-2d HRC",
                getType(),
                getProductieDag().toString(),
                getMateriaal(),
                getHardheid());
    }
}
