package be.kdg.generics;

import java.util.*;

/**
 * Vincent Verboven
 * 25/09/2023
 */
public class PriorityQueue<T> implements FIFOQueue<T> {

    private final Map<Integer, LinkedList<T>> map;

    public PriorityQueue() {
        map = new TreeMap<>(Collections.reverseOrder());
    }

    @Override
    public boolean enqueue(T element, int priority) {
        for (int k : map.keySet()) {
            if (map.get(k).contains(element)) return false;
        }
        if (map.get(priority) == null) {
            map.put(priority, new LinkedList<>(Collections.singletonList(element)));
        } else {
            map.get(priority).add(element);
        }
        return true;
    }

    @Override
    public T dequeue() {
        for(int k : map.keySet()){
            if (map.get(k) != null && !map.get(k).isEmpty()){
                T element = map.get(k).get(0);
                map.get(k).remove(element);
                return element;
            }
        }
        return null;
    }

    @Override
    public int search(T element) {
        int i = 0;
        for(int k : map.keySet()){
            for(T e : map.get(k)){
                i++;
                if(e.equals(element)) return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        int i = 0;
        for(int k : map.keySet()){
            i += map.get(k).size();
        }
        return i;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int k : map.keySet()){
            for(T element : map.get(k)){
                string.append(k).append(": ").append(element).append("\n");
            }
        }
        return string.toString();
    }
}
