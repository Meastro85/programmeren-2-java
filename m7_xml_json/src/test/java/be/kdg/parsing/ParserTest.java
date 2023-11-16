package be.kdg.parsing;

import be.kdg.data.Data;
import be.kdg.model.Messen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class ParserTest {

    private Messen messen;

    @BeforeEach
    void setUp(){
        messen = new Messen();
        Data.getData().forEach(mes -> messen.add(mes));
    }

    @Test
    void testStaxDom(){
        Messen parsedMessen = null;
        try{
            MessenStaxParser parser = new MessenStaxParser(messen, "datafiles/staxMessen.xml");
            parser.staxWriteXML();
            parsedMessen = MessenDomParser.domReadXML("datafiles/staxMessen.xml");
        } catch (Exception e){
            System.out.println(e.toString());
        }
            assertEquals(messen, parsedMessen, "De twee multi objecten moeten gelijk zijn aan elkaar");
    }

    @Test
    void testJaxb(){
        Messen parsedMessen = null;
        try{
            MessenJaxbParser.JaxbWriteXml("datafiles/jaxbMessen.xml", messen);
            parsedMessen = MessenJaxbParser.JaxbReadXml("datafiles/jaxbMessen.xml", Messen.class);
        } catch (Exception e){
            System.out.println(e);
        }
        assertEquals(messen, parsedMessen, "De twee multi objecten moeten gelijk zijn aan elkaar");
    }

    @Test
    void testGson(){
        Messen parsedMessen = null;
        try{
            MessenGsonParser.writeJson(messen, "datafiles/gsonMessen.json");
            parsedMessen = MessenGsonParser.readJson("datafiles/gsonMessen.json");
        } catch (Exception e){
            System.out.println(e);
        }
        assertEquals(messen, parsedMessen, "De twee multi objecten moeten gelijk zijn aan elkaar");
    }

}
