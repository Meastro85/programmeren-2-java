package be.kdg.persist;

import be.kdg.model.Messen;

import java.io.*;

/**
 * Vincent Verboven
 * 23/10/2023
 */
public class MessenSerializer {
    private final String FILENAME;


    public MessenSerializer(String fileName){
        FILENAME = fileName;
    }

    public void serialize(Messen messen) throws IOException {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("db/" + FILENAME))){
            outputStream.writeObject(messen);
        }
    }

    public Messen deserialize() throws IOException, ClassNotFoundException{
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("db/" + FILENAME))){
            return (Messen)inputStream.readObject();
        }
    }

}
