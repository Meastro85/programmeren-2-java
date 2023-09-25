package be.kdg.generics;

/**
 * Vincent Verboven
 * 25/09/2023
 */
public interface FIFOQueue<T> {
    boolean enqueue(T element, int priority);
    T dequeue();
    int search(T element);
    int getSize();
}
