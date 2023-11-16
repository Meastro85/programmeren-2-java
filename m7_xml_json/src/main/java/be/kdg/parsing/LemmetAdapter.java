package be.kdg.parsing;

import be.kdg.model.Lemmet;
import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class LemmetAdapter extends XmlAdapter<String, Lemmet> {
    @Override
    public Lemmet unmarshal(String v) throws Exception {
        return Lemmet.valueOf(v.toUpperCase());
    }

    @Override
    public String marshal(Lemmet v) throws Exception {
        return v.toString();
    }
}
