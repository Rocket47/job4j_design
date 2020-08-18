package list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    int capacity = 10;
    int currentIndex = 0;
    int modCount = 0;
    int indexIterator = 0;
    Object[] container = new Object[capacity];

    public T get(int index) {
        Objects.checkIndex(index, this.currentIndex);
        return (T) container[currentIndex];
    }

    public void add(T model) {
        if (container.length >= capacity) {
            container = Arrays.copyOf(container, capacity * 2);
        }
        container[currentIndex] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        if (!this.iterator().hasNext()) {
            throw new NoSuchElementException();
        }
        if (expectedModCount >= modCount) {
            throw new ConcurrentModificationException();
        }
        return (Iterator<T>) container[indexIterator++];
    }
}
