import data.Data;
import model.Lemmet;
import model.Mes;
import model.Messen;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.LogManager;

/**
 * Vincent Verboven
 * 16/10/2023
 */
public class Demo_5 {
    public static void main(String[] args) throws IOException {

        InputStream inputStream = Demo_5.class.getResourceAsStream("logging.properties");
        LogManager.getLogManager().readConfiguration(inputStream);

        new Mes("", LocalDate.of(2015, 3,10),20.5, 58, "Roestvrij staal", Lemmet.NORMAAL);
        new Mes("test", LocalDate.of(2015, 3,10),-5, 58, "Roestvrij staal", Lemmet.NORMAAL);
        new Mes("test", LocalDate.of(2015, 3,10),50, -5, "Roestvrij staal", Lemmet.NORMAAL);
        new Mes("test", LocalDate.of(2015, 3,10),50, -5, "", Lemmet.NORMAAL);
        new Mes("Broodmes", LocalDate.of(2024,3,10),22.2, 62, "High Carbon Steel", Lemmet.SCHAAPSVOET);
        Messen messen = new Messen();
        List<Mes> data = Data.getData();
        data.forEach(messen::add);
        messen.remove(data.get(0).getType(), data.get(0).getProductieDag(), data.get(0).getLemmet(), data.get(0).getLengte(), data.get(0).getHardheid(), data.get(0).getMateriaal());
    }
}
