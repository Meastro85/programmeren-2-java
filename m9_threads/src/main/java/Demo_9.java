import be.kdg.model.Lemmet;
import be.kdg.threading.MesRunnable;

/**
 * Vincent Verboven
 * 7/12/2023
 */
public class Demo_9 {
    private static final double TESTCOUNT = 100;
    public static void main(String[] args) throws InterruptedException {
        MesRunnable mesRunnable1 = new MesRunnable(mes -> mes.getLemmet() == Lemmet.DROPPOINT);
        MesRunnable mesRunnable2 = new MesRunnable(mes -> mes.getLemmet() == Lemmet.KLIP);
        MesRunnable mesRunnable3 = new MesRunnable(mes -> mes.getLemmet() == Lemmet.SCHAAPSVOET);
        long totalTimeTaken = 0;
        for(int i = 0; i < TESTCOUNT; i++) {
            Thread mesThread1 = new Thread(mesRunnable1);
            Thread mesThread2 = new Thread(mesRunnable2);
            Thread mesThread3 = new Thread(mesRunnable3);
            long start = System.currentTimeMillis();
            mesThread1.start();
            mesThread2.start();
            mesThread3.start();
            mesThread1.join();
            mesThread2.join();
            mesThread3.join();
            long end = System.currentTimeMillis();
            long timeTaken = end - start;
            totalTimeTaken += timeTaken;
            System.out.println("Time taken: " + timeTaken + "ms");

            System.out.println("Filter: Lemmet = DROPPOINT");
            mesRunnable1.getMesList().stream().limit(5).forEach(System.out::println);
            System.out.println("Filter: Lemmet = KLIP");
            mesRunnable2.getMesList().stream().limit(5).forEach(System.out::println);
            System.out.println("Filter: Lemmet = SCHAAPSVOET");
            mesRunnable3.getMesList().stream().limit(5).forEach(System.out::println);
        }
        System.out.println("3 threads verzamelen elk 1000 messen (gemiddelde uit " + TESTCOUNT + " runs) : " + (double)(totalTimeTaken/TESTCOUNT) + "ms");
    }
}
