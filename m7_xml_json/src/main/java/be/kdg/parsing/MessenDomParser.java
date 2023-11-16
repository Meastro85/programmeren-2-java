package be.kdg.parsing;

import be.kdg.model.Lemmet;
import be.kdg.model.Mes;
import be.kdg.model.Messen;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class MessenDomParser {

    public static Messen domReadXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        Messen messen = new Messen();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new File(fileName));
        Element rootElement = doc.getDocumentElement();
        NodeList messenList = rootElement.getChildNodes();
        for(int i = 0; i < messenList.getLength(); i++){
            if(messenList.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue;
            }
            Element e = (Element) messenList.item(i);
            messen.add(readElement(e));
        }
        return messen;
    }

    private static Mes readElement(Element e){
        String type = e.getAttribute("type");
        int hardheid = Integer.parseInt(e.getElementsByTagName("hardheid").item(0).getTextContent());
        String materiaal = e.getElementsByTagName("materiaal").item(0).getTextContent();
        double lengte = Double.parseDouble(e.getElementsByTagName("lengte").item(0).getTextContent());
        LocalDate productiedag = LocalDate.parse(e.getElementsByTagName("productiedag").item(0).getTextContent());
        Lemmet lemmet = Lemmet.valueOf(e.getElementsByTagName("lemmet").item(0).getTextContent().toUpperCase());
        return new Mes(type, productiedag, lengte, hardheid, materiaal, lemmet);
    }

}
