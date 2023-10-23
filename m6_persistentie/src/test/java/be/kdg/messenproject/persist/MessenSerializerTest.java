package be.kdg.messenproject.persist;

import be.kdg.data.Data;
import be.kdg.model.Mes;
import be.kdg.model.Messen;
import be.kdg.persist.MessenSerializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vincent Verboven
 * 23/10/2023
 */
public class MessenSerializerTest {

    private Messen messen;
    private MessenSerializer serializer;

    @BeforeEach
    void setUp(){
        messen = new Messen();
        Data.getData().forEach(messen::add);
        serializer = new MessenSerializer("messen.ser");
    }

    @AfterEach
    void tearDown(){
        messen = null;
        serializer = null;
    }

    @Test
    public void testSerialize(){
        assertDoesNotThrow(() -> serializer.serialize(messen), "Het serializeren van het messen object mag geen exception terug geven.");
    }

    @Test
    public void testDeserialize(){
        Messen deserializedMessen = assertDoesNotThrow(() -> serializer.deserialize(), "Het deserializeren van het messen object mag geen exception terug geven.");
        assertEquals(messen, deserializedMessen, "De objecten moeten gelijk zijn aan elkaar.");
    }

}
