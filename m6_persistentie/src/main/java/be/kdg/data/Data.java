package be.kdg.data;

import be.kdg.model.Lemmet;
import be.kdg.model.Mes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Mes> getData(){
        List<Mes> mesList = new ArrayList<>();
        mesList.add(new Mes("Koksmes", LocalDate.of(2015, 3,10),20.5, 58, "Roestvrij staal", Lemmet.NORMAAL));
        mesList.add(new Mes("Broodmes", LocalDate.of(2019, 9,5),22.2, 62, "High Carbon Steel", Lemmet.SCHAAPSVOET));
        mesList.add(new Mes("Vleesmes", LocalDate.of(2007, 7,14),25.1, 56, "Roestvrij staal", Lemmet.DROPPOINT));
        mesList.add(new Mes("Santokumes", LocalDate.of(2018, 2,3),18.8, 60, "Damascus staal", Lemmet.KLIP));
        mesList.add(new Mes("Schilmes", LocalDate.of(2012, 5,20),10.3, 54, "Koolstofstaal", Lemmet.NORMAAL));
        mesList.add(new Mes("Fileermes", LocalDate.of(2010, 8,8),15.7, 59, "Roestvrij staal", Lemmet.SCHAAPSVOET));
        mesList.add(new Mes("Nakiri-mes", LocalDate.of(2017, 6,12),16.4, 61, "High Carbon Stainless Steel", Lemmet.SCHAAPSVOET));
        mesList.add(new Mes("Uitbeenmes", LocalDate.of(2005, 10,18),14.9, 55, "Roestvrij staal", Lemmet.KLIP));
        mesList.add(new Mes("Steakmes", LocalDate.of(2014, 3,30),12.6, 57, "Roestvrij staal", Lemmet.NORMAAL));
        mesList.add(new Mes("Keukenmes", LocalDate.of(2022, 9,7),19.2, 63, "Damascus staal", Lemmet.SCHAAPSVOET));
        mesList.add(new Mes("Visfileermes", LocalDate.of(2011, 1,25),18.5, 58, "High Carbon Stainless Steel", Lemmet.DROPPOINT));
        mesList.add(new Mes("Hakmes", LocalDate.of(2013, 4,9),20.7, 60, "High Carbon Steel", Lemmet.KLIP));
        mesList.add(new Mes("Schilmes", LocalDate.of(2016, 8,22),8.9, 56, "Roestvrij staal", Lemmet.NORMAAL));
        mesList.add(new Mes("Gyuto-mes", LocalDate.of(2018, 5,11),21.3, 61, "Damascus staal", Lemmet.SCHAAPSVOET));
        mesList.add(new Mes("Jachtmes", LocalDate.of(2002, 10,17),12.4, 58, "Roestvrij staal", Lemmet.DROPPOINT));
        return mesList;
    }
}
