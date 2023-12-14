package be.kdg.threading;

import be.kdg.model.Mes;
import be.kdg.model.MesFactory;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Vincent Verboven
 * 14/12/2023
 */
public class MesCallable implements Callable<List<Mes>> {

    Predicate<Mes> predicate;

    public MesCallable(Predicate<Mes> predicate){
        this.predicate = predicate;
    }

    @Override
    public List<Mes> call() throws Exception {
        return Stream.generate(MesFactory::newRandomMes).filter(predicate).limit(1000).collect(Collectors.toList());
    }
}
