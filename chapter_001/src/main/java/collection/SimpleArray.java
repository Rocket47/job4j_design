package collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    int capacity = 10;
    int currentIndex = 0;
    int modCount = 0;

    private Object[] container = new Object[capacity];

    public T get(int index) {
        Objects.checkIndex(index, this.currentIndex);
        return (T) container[index];
    }

    public void add(T model) {
        if (container.length > capacity) {
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
                if (indexIterator < currentIndex) {
                    return true;
                }
                return false;
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
