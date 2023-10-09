package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

/**
 * Vincent Verboven
 * 9/10/2023
 */
public class MesFunctions<T> {
    public static <T> List<T> filteredList(List<T> mesList, Predicate<T> predicate){
        return mesList.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T> double average(List<T> mesList, ToDoubleFunction<T> mapper){
        return mesList.stream().mapToDouble(mapper).average().getAsDouble();
    }

    public static <T> long countIf(List<T> mesList, Predicate<T> predicate){
        return mesList.stream().filter(predicate).count();
    }

}
