package be.kdg.parsing;

import be.kdg.model.Mes;
import be.kdg.model.Messen;
import com.sun.xml.txw2.output.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class MessenStaxParser {
    private final Messen messen;
    private final IndentingXMLStreamWriter streamWriter;

    public MessenStaxParser(Messen messen, String path) throws IOException, XMLStreamException {
        FileWriter file = new FileWriter(path);
        XMLStreamWriter xmlWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(file);
        streamWriter = new IndentingXMLStreamWriter(xmlWriter);
        this.messen = messen;
    }

    public void staxWriteXML() throws XMLStreamException {
        streamWriter.writeStartDocument();
        streamWriter.writeStartElement("messen");
        for(Mes mes: messen.sortedOnType()){
            writeElement(mes);
        }
        streamWriter.writeEndElement();
        streamWriter.writeEndDocument();
        streamWriter.close();
    }

    private void writeElement(Mes mes) throws XMLStreamException {
        streamWriter.writeStartElement("mes");
        streamWriter.writeAttribute("type", mes.getType());
        streamWriter.writeStartElement("materiaal");
        streamWriter.writeCharacters(mes.getMateriaal());
        streamWriter.writeEndElement();
        streamWriter.writeStartElement("hardheid");
        streamWriter.writeCharacters(Integer.toString(mes.getHardheid()));
        streamWriter.writeEndElement();
        streamWriter.writeStartElement("lemmet");
        streamWriter.writeCharacters(mes.getLemmet().toString());
        streamWriter.writeEndElement();
        streamWriter.writeStartElement("lengte");
        streamWriter.writeCharacters(Double.toString(mes.getLengte()));
        streamWriter.writeEndElement();
        streamWriter.writeStartElement("productiedag");
        streamWriter.writeCharacters(mes.getProductieDag().toString());
        streamWriter.writeEndElement();
        streamWriter.writeEndElement();
    }

}
