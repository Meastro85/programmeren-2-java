package be.kdg.kollections.lists;


public class LinkedList<E> implements List<E> {
    static class Node<V> {
        V value;
        Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

    private Node<E> root;
    private int size;

    public LinkedList() {
    }

    @Override
    public void add(int index, E element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (root == null) {
            root = new Node<>(element);
        }
        Node<E> node = root;
        if (index < size) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            Node<E> oldNode = node;
            Node<E> nextNode = node.next;
            node.value = element;
            for(int i = index; i < size; i++){
                E tempValue = nextNode.value;
                nextNode.value = oldNode.value;
                oldNode.value = tempValue;

                oldNode = nextNode;
                if (nextNode.next != null) {
                    nextNode = nextNode.next;
                }
            }
            oldNode.next = new Node<>(oldNode.value);
        } else {
            while (node != null) {
                if (node.next == null) {
                    node.next = new Node<>(element);
                    break;
                }
                node = node.next;
            }
        }
        size++;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        E oldElement = remove(index);
        return oldElement != null;
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
        Node<E> node = root;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.value = element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = root;
        int counter = 0;
        while(node.next != null){
            if(node.value == element) return counter;
            counter++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        if (index == 0) {
            E oldElement = root.value;
            root = root.next;
            size--;
            return oldElement;
        } else {
            Node<E> beforeNode = root;
            for (int i = 1; i < index; i++) {
                beforeNode = beforeNode.next;
            }
            E oldElement = beforeNode.next.value;
            beforeNode.next = beforeNode.next.next;
            size--;
            return oldElement;
        }
    }

    @Override
    public E get(int index) {
        if (index >= this.size || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        Node<E> node = root;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.value;
    }
}
