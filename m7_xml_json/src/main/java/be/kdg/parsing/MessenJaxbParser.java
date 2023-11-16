package be.kdg.parsing;

import be.kdg.model.Messen;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class MessenJaxbParser {
    public static void JaxbWriteXml(String file, Object root) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Messen.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(root, new File(file));
    }

    public static <T> T JaxbReadXml(String file, Class<T> typeParameterClass) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(typeParameterClass);
        Unmarshaller u = context.createUnmarshaller();
        File f = new File(file);
        T t = (T) u.unmarshal(f);
        return t;
    }

}
