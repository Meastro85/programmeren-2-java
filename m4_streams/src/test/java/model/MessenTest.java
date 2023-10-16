package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vincent Verboven
 * 16/10/2023
 */
class MessenTest {

    private Mes m1;
    private Mes m2;
    private Mes m3;
    private Mes m4;
    private Mes m5;
    private Messen messen;

    @BeforeEach
    void setUp() {
        m1 = new Mes("Koksmes", LocalDate.of(2015, 3,10),20.5, 58, "Roestvrij staal", Lemmet.NORMAAL);
        m2 = new Mes("Broodmes", LocalDate.of(2019, 9,5),22.2, 62, "High Carbon Steel", Lemmet.SCHAAPSVOET);
        m3 = new Mes("Vleesmes", LocalDate.of(2007, 7,14),25.1, 56, "Roestvrij staal", Lemmet.DROPPOINT);
        m4 = new Mes("Santokumes", LocalDate.of(2018, 2,3),18.8, 60, "Damascus staal", Lemmet.KLIP);
        m5 = new Mes("Schilmes", LocalDate.of(2012, 5,20),10.3, 54, "Koolstofstaal", Lemmet.NORMAAL);
        messen = new Messen();
        messen.add(m1);
        messen.add(m2);
        messen.add(m3);
        messen.add(m4);
        messen.add(m5);
    }

    @AfterEach
    void tearDown() {
        m1 = null;
        m2 = null;
        m3 = null;
        m4 = null;
        m5 = null;
        messen = null;
    }

    @Test
    public void testAdd(){
        int messenSize = messen.getSize();
        messen.add(m1);
        assertEquals(messenSize, messen.getSize(), "Duplicate objecten mogen niet toegevoegd worden.");
    }

    @Test
    public void testDelete(){
        int messenSize = messen.getSize();
        messen.remove("Koksmes", LocalDate.of(2015, 3,10),Lemmet.NORMAAL, 20.5, 58, "Roestvrij staal");
        assertEquals(messenSize - 1, messen.getSize(), "Na het verwijderen van een object moet de lijst kleiner zijn.");
        assertFalse(messen.remove("a", LocalDate.now(), Lemmet.DROPPOINT, 1, 24, "tm"), "Het verwijderen van een onbestaand object moet false returnen.");
    }

    @Test
    public void testSortingByHardheid(){
        List<Mes> sortedList = messen.sortedBy(Mes::getHardheid);
        assertAll(() -> assertEquals(m5, sortedList.get(0), "Lijst is niet correct gesorteerd op hardheid"),
                () -> assertEquals(m3, sortedList.get(1),"Lijst is niet correct gesorteerd op hardheid"),
                () -> assertEquals(m1, sortedList.get(2), "Lijst is niet correct gesorteerd op hardheid")
                );
    }

    @Test
    public void testSortingByLengte(){
        Mes[] sortedArray = messen.sortedBy(Mes::getLengte).toArray(new Mes[0]);
        Mes[] createdArray = new Mes[] { m5, m4, m1, m2 ,m3};
        assertArrayEquals(createdArray, sortedArray, "Lijst is niet correct gesorteerd op lengte.");
    }

}