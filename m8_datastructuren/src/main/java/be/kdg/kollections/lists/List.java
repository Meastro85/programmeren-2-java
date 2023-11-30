package be.kdg.kollections.lists;

import be.kdg.kollections.Collection;

public interface List<T> extends Collection<T> {
    void add(int index, T element);
    void add(T element);
    void set(int index, T element);
    int size();
    int indexOf(T element);
    T remove(int index);
    T get(int index);
}
