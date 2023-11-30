package be.kdg.kollections.lists;

import be.kdg.kollections.Kollections;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int maxSize = INITIAL_CAPACITY;

    public ArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    public ArrayList(int size) {
        elements = new Object[size];
        this.size = size;
    }

    private void expand() {
        maxSize = (int)(size*1.1);
        this.elements = Arrays.copyOf(elements, maxSize);
    }

    @Override
    public void add(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if(size == maxSize)
        {
            expand();
        }
        if(index != size-1){
            for(int i = size-1; i >= index; i--){
                elements[i+1] = elements[i];
            }
        }
        elements[index] = element;
        size++;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if(index > 0){
            elements[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @Override
    public void set(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        elements[index] = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        return Kollections.lineairSearch(this,element);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        E oldValue = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return oldValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        return (E)elements[index];
    }
}
