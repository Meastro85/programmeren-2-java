package be.kdg.parsing;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}
