import be.kdg.data.Data;
import be.kdg.generics.PriorityQueue;
import be.kdg.model.Lemmet;
import be.kdg.model.Mes;

import java.time.LocalDate;
import java.util.Random;

/**
 * Vincent Verboven
 * 25/09/2023
 */
public class Demo_2 {
    public static void main(String[] args) {
        var myQueue = new PriorityQueue<Mes>();
        var r = new Random();
        var data = Data.getData();
        for(var mes : data){
            myQueue.enqueue(mes, r.nextInt(1,6));
        }
        System.out.println("Overzicht van de PriorityQueue:");
        System.out.println(myQueue);
        System.out.println("aantal: " + myQueue.getSize());
        System.out.println("Positie van Schilmes: " + myQueue.search(new Mes("Schilmes", LocalDate.of(2012, 5,20),10.3, 54, "Koolstofstaal", Lemmet.NORMAAL)));
        for(int i = 0; i < 10; i++){
            myQueue.dequeue();
        }
        System.out.printf("Aantal na dequeue: " + myQueue.getSize());
    }
}
