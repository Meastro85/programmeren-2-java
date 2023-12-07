package be.kdg.threading;

import be.kdg.model.Mes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Vincent Verboven
 * 7/12/2023
 */
public class MesAttacker implements Runnable{

    private static final Object LOCK = new Object();
    private List<Mes> mesList;
    private Predicate<Mes> predicate;

    public MesAttacker(List<Mes> mesList, Predicate<Mes> predicate){
        this.mesList = mesList;
        this.predicate = predicate;
    }

    @Override
    public void run() {
        synchronized (LOCK){
            mesList.removeIf(predicate);
        }
    }
}
