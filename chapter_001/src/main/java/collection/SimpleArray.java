package collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 10;
    private int currentIndex = 0;
    private int modCount = 0;

    private Object[] container = new Object[capacity];

    public T get(int index) {
        Objects.checkIndex(index, this.currentIndex);
        return (T) container[index];
    }

    public void add(T model) {
        if (currentIndex == capacity - 1) {
            container = Arrays.copyOf(container, capacity * 2);
        }
        container[currentIndex] = model;
        modCount++;
        currentIndex++;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int indexIterator = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return indexIterator < currentIndex;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[indexIterator++];
            }
        };
    }
}
