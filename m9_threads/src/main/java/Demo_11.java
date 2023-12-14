import be.kdg.model.Lemmet;
import be.kdg.model.Mes;
import be.kdg.threading.MesCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Vincent Verboven
 * 14/12/2023
 */
public class Demo_11 {
    public final static int TEST_COUNT = 100;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MesCallable mesCallable1 = new MesCallable(mes -> mes.getLemmet() == Lemmet.DROPPOINT);
        MesCallable mesCallable2 = new MesCallable(mes -> mes.getLengte() > 20);
        MesCallable mesCallable3 = new MesCallable(mes -> mes.getHardheid() > 60);

        ExecutorService execServ = Executors.newFixedThreadPool(3);
        List<Future<List<Mes>>> futureList = new ArrayList<>();

        futureList.add(execServ.submit(mesCallable1));
        futureList.add(execServ.submit(mesCallable2));
        futureList.add(execServ.submit(mesCallable3));

        double start = System.currentTimeMillis();
        for(int i = 0; i < TEST_COUNT; i++){
            for(Future<List<Mes>> future : futureList) future.get();
        }
        double end = System.currentTimeMillis();

        System.out.println("3 Futures verzamelen elk 1000 messen (gemiddelde uit " + TEST_COUNT + " runs): " + (end - start) + " ms");

        execServ.shutdown();

    }
}
