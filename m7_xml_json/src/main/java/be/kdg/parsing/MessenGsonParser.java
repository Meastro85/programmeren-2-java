package be.kdg.parsing;

import be.kdg.model.Mes;
import be.kdg.model.Messen;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Vincent Verboven
 * 16/11/2023
 */
public class MessenGsonParser {

    public static void writeJson(Messen messen, String fileName) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(LocalDate.class, new LocalDateGsonAdapter().nullSafe()).setPrettyPrinting().create();
        String jsonString = gson.toJson(messen);
        try(FileWriter jsonWriter = new FileWriter(fileName)){
            jsonWriter.write(jsonString);
        }
    }

    public static Messen readJson(String fileName) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.registerTypeAdapter(LocalDate.class, new LocalDateGsonAdapter().nullSafe()).create();
        Messen messen;
        try(BufferedReader data = new BufferedReader(new FileReader(fileName))){
            messen = gson.fromJson(data, Messen.class);
        }
        return messen;
    }

}
