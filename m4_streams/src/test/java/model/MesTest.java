package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vincent Verboven
 * 16/10/2023
 */
class MesTest {
    private Mes m1;
    private Mes m2;

    @BeforeEach
    public void setUp() {
        m1 = new Mes("Vlindermes", LocalDate.now(), 20.5, 60, "Stainless Steel", Lemmet.KLIP);
        m2 = new Mes("Koksmes", LocalDate.of(2015, 3,10),20.5, 58, "Roestvrij staal", Lemmet.NORMAAL);
    }

    @AfterEach
    void tearDown() {
        m1 = null;
        m2 = null;
    }

    @Test
    public void testEquals(){
        assertNotEquals(m1, m2, "De objecten moeten verschillen van elkaar");
        Mes m3 = new Mes("Vlindermes", LocalDate.now(), 20.5, 60, "Stainless Steel", Lemmet.KLIP);
        assertEquals(m1, m3, "De objecten moeten dezelfde eigenschappen hebben");
    }

    @Test
    public void testIllegalMateriaal(){
        assertThrows(IllegalArgumentException.class, () -> m1.setMateriaal(""), "Het zetten van een leeg materiaal moet een exception geven.");
    }

    @Test
    public void testLegalMateriaal(){
        assertDoesNotThrow(() -> m1.setMateriaal("test"), "Het zetten van een geldig materiaal mag geen exception geven.");
    }

    @Test
    public void testCompareTo(){
        Mes m3 = new Mes("Vlindermes", LocalDate.now(), 20.5, 60, "Stainless Steel", Lemmet.KLIP);
        assertEquals(0, m1.compareTo(m3), "Objecten die hetzelfde zijn moeten 0 terug geven");
    }

    @Test
    public void testLengte(){
        assertEquals(20, m1.getLengte(), 0.5, "Lengte mag niet minder of meer dan 0,5 van 20 af liggen.");
    }

}