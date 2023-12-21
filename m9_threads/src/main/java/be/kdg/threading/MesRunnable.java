package be.kdg.threading;

import be.kdg.model.Mes;
import be.kdg.model.MesFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Vincent Verboven
 * 7/12/2023
 */
public class MesRunnable implements Runnable {
    private Predicate<Mes> predicate;
    private List<Mes> mesList;
    public MesRunnable(Predicate<Mes> predicate){
        this.predicate = predicate;
    }

    public List<Mes> getMesList(){
        return mesList;
    }

    @Override
    public void run() {
        mesList = Stream.generate(MesFactory::newRandomMes).filter(mes -> predicate.test(mes)).limit(1000).toList();
    }
}
