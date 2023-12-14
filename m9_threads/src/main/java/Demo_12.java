import be.kdg.model.MesFactory;
import be.kdg.model.Messen;
import be.kdg.threading.MesRunnable;

import java.util.stream.Stream;

/**
 * Vincent Verboven
 * 14/12/2023
 */
public class Demo_12 {
    public static void main(String[] args) throws InterruptedException {
        Messen messen = new Messen(10000);
        Runnable runnable = () -> Stream.generate(MesFactory::newRandomMes).limit(5000).forEach(messen::add);

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Na toevoegen door 2 threads met elk 5000 objecten: messen = " + messen.getSize());

    }
}
